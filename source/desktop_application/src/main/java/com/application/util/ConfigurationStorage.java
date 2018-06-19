package com.application.util;

public abstract class ConfigurationStorage {
	// user data
	private static String firstName;
	private static String lastName;
	private static String gender;
	private static String address;
	private static String phoneNumber;
	private static String bloodType;

	// contact person data
	private static String contactPersonName;
	private static String contactPersonEmail;

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
