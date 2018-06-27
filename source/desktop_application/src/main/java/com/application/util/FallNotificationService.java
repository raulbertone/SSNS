package com.application.util;

import com.application.mainController;

public class FallNotificationService implements Runnable{

	private static FallNotificationService instance;
	private boolean fallDetected = false;
	private boolean run = true;
	private boolean falseAlarm = false;
	private mainController controller;

	static{
		instance = new FallNotificationService();
		
		(new Thread(instance)).start();
		
    }

	/*
	 * Static methods
	 */

	// call this method when a fall is detected
	public static void notifyFall() {
		instance.setFallFlag();
	}

	// call this method to stop the service. It is meant to be called just before turning the application off.
	public static void stop() {
		instance.run = false;
	}

	// call this method to signal a false alarm (when the user presses a button on the Sensortag)
	public static void falseAlarm() {
		instance.falseAlarm = true;
	}
	
	public static void setMain(mainController controller) {
		instance.controller = controller;
	}

	/*
	 * Instance methods
	 */
	@Override
	public void run() {

		while(run) {
			waitForFall();
		}
	}

	private synchronized void waitForFall() {

		// wait on this
		while (!fallDetected) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// to prevent random button presses to incorrectly "pre-declare" a fall as a false alarm
		falseAlarm = false;

		// TODO turn on the buzzer
		instance.controller.setLblFallDetColor("#a20000"); // raise flag in the GUI

		// wait to see if the user signals a false alarm
		try {
			wait(ConfigurationStorage.getHELP_REQUEST_DELAY());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (falseAlarm) {
			// TODO turn off the buzzer
			instance.controller.setLblFallDetColor("#000000"); // lower the flag in the GUI
		} else {
			
			requestHelp(); // send email
			instance.controller.setLblHelpReqColor("#a20000"); // raise flag in the GUI

			fallDetected = false;
		}
	}

	private synchronized void setFallFlag() {
		fallDetected = true;
		notify();
	}

	// helper method that prepares the email and sends it
	private void requestHelp() {
		String messageBody = ConfigurationStorage.getFIRST_NAME() + " " + ConfigurationStorage.getLAST_NAME() + " living at " + ConfigurationStorage.getADDRESS() +
							 " has fallen and requires assistance";
		String toAddress = ConfigurationStorage.getCONTACT_PERSON_EMAIL();

		try {
			SendMail.send(messageBody, "Help! I have fallen!", toAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
