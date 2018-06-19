package com.application.util;

public abstract class ConfigurationStorage {
	// user's data
	private static String firstName = "John";
	private static String lastName = "Doh";
	private static String gender = "M";
	private static String address = "Some Street 5, Onecity";
	private static String phoneNumber = "555-123456789";
	private static String bloodType = "AB-";

	// contact person's data
	private static String contactPersonName = "Good Samaritan";
	private static String contactPersonEmail = "bert1.raul@gmail.com";


	// fall detection algorithm's settings

	// help request settings
	private static int helpRequestDelay = 5;

	public static int getHelpRequestDelay() {
		return helpRequestDelay;
	}
	public static void setHelpRequestDelay(int helpRequestDelay) {
		ConfigurationStorage.helpRequestDelay = helpRequestDelay;
	}
	public static String getFirstName() {
		return firstName;
	}
	public static void setFirstName(String firstName) {
		ConfigurationStorage.firstName = firstName;
	}
	public static String getLastName() {
		return lastName;
	}
	public static void setLastName(String lastName) {
		ConfigurationStorage.lastName = lastName;
	}
	public static String getGender() {
		return gender;
	}
	public static void setGender(String gender) {
		ConfigurationStorage.gender = gender;
	}
	public static String getAddress() {
		return address;
	}
	public static void setAddress(String address) {
		ConfigurationStorage.address = address;
	}
	public static String getPhoneNumber() {
		return phoneNumber;
	}
	public static void setPhoneNumber(String phoneNumber) {
		ConfigurationStorage.phoneNumber = phoneNumber;
	}
	public static String getBloodType() {
		return bloodType;
	}
	public static void setBloodType(String bloodType) {
		ConfigurationStorage.bloodType = bloodType;
	}
	public static String getContactPersonName() {
		return contactPersonName;
	}
	public static void setContactPersonName(String contactPersonName) {
		ConfigurationStorage.contactPersonName = contactPersonName;
	}
	public static String getContactPersonEmail() {
		return contactPersonEmail;
	}
	public static void setContactPersonEmail(String contactPersonEmail) {
		ConfigurationStorage.contactPersonEmail = contactPersonEmail;
	}
}
