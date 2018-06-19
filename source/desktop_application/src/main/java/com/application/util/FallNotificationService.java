package com.application.util;

public class FallNotificationService implements Runnable{

	private static FallNotificationService instance;
	private boolean fallDetected = false;
	private boolean run = true;
	private boolean falseAlarm = false;

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
		// TODO raise flag in the GUI

		// wait to see if the user signals a false alarm
		try {
			wait(ConfigurationStorage.getHelpRequestDelay());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (falseAlarm) {
			// TODO turn off the buzzer
			// TODO lower the flag in the GUI
		} else {
			// send email
			requestHelp();

			// TODO raise flag in the GUI

			fallDetected = false;
		}
	}

	private synchronized void setFallFlag() {
		fallDetected = true;
		notify();
	}

	// helper method that prepares the email and sends it
	private void requestHelp() {
		String messageBody = ConfigurationStorage.getFirstName() + " " + ConfigurationStorage.getLastName() + " living at " + ConfigurationStorage.getAddress() +
							 " has fallen and requires assistance";
		String toAddress = ConfigurationStorage.getContactPersonEmail();

		try {
			SendMail.send(messageBody, "Help! I have fallen!", toAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
