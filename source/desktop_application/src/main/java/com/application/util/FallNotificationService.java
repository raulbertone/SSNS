package com.application.util;

import com.application.mainController;

/**
 * This class handles the notifications triggered by the detection of a fall.
 * On start it idles while waiting for a trigger. When the fall detection
 * algorithm thinks the user has fallen, it alerts the FNS which turns on and off
 * the buzzer on the Sensortags, the flags in the GUI and sends emails accordingly.
 *
 * @author Raul Bertone
 */
public class FallNotificationService implements Runnable{

	private static FallNotificationService instance;
	private boolean fallDetected = false;
	private boolean run = true;
	private boolean falseAlarm = false;
	private mainController controller;
	private boolean fallHappened = false;

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
	public static void notifyFalseAlarm() {
		instance.setFalseAlarm();
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

	private synchronized void setFalseAlarm() {
		instance.falseAlarm = true;
		notify();
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

		if(falseAlarm & fallHappened) {
			// TODO turn off the buzzer
			instance.controller.setLblFallDetColor("#000000"); // lower Fall flag in the GUI
			instance.controller.setLblHelpReqColor("#000000"); // lower Help flag in the GUI

			String message = " says it was a false alarm, everything's fine";
			sendMail(message);
			fallHappened = false;
			return;
		}

		// to prevent random button presses to incorrectly "pre-declare" a fall as a false alarm
		falseAlarm = false;

		// TODO turn on the buzzer
		instance.controller.setLblFallDetColor("#a20000"); // raise flag in the GUI

		// wait to see if the user signals a false alarm
		try {
			Thread.sleep(ConfigurationStorage.getHELP_REQUEST_DELAY());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (falseAlarm) {
			// TODO turn off the buzzer
			instance.controller.setLblFallDetColor("#000000"); // lower the flag in the GUI
			falseAlarm = false;
		} else {
			fallHappened = true;

			String message = " has fallen and requires assistance";

			sendMail(message); // send email
			instance.controller.setLblHelpReqColor("#a20000"); // raise flag in the GUI

			fallDetected = false;
		}
	}

	private synchronized void setFallFlag() {
		fallDetected = true;
		notify();
	}

	// helper method that prepares the email and sends it
	private void sendMail(String message) {
		String messageBody = ConfigurationStorage.getFIRST_NAME() + " " + ConfigurationStorage.getLAST_NAME() + " living at " + ConfigurationStorage.getADDRESS() + message;
		String toAddress = ConfigurationStorage.getCONTACT_PERSON_EMAIL();

		try {
			SendMail.send(messageBody, "Help! I have fallen!", toAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
