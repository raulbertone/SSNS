package com.application.util;

public abstract class ConfigurationStorage {
	// user's data
	private static String FIRST_NAME = "John";
	private static String LAST_NAME = "Doh";
	private static String GENDER = "M";
	private static String ADDRESS = "Some Street 5, Onecity";
	private static String PHONE_NUMBER = "555-123456789";
	private static String BLOOD_TYPE = "AB-";

	// contact person's data
	private static String CONTACT_PERSON_NAME = "Good Samaritan";
	private static String CONTACT_PERSON_EMAIL = "bert1.raul@gmail.com";

	// fall detection algorithm's settings
	private static double IMPACT_POW = 4.0; // Value of Impact(g)
	private static int IMPACT_PASS = 0; // Measurements after Impact(count)
	private static double LAYING_POW = 1.0; // double, Laying Acceleration(g)
	private static int SKIP_MEASURE = 0; // Skipped Measurements(count)
	private static double FALL_ANGLE = 30.0; // Fall angle(degrees)

	// help request settings
	private static int HELP_REQUEST_DELAY = 5;

	public static String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public static void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}

	public static String getLAST_NAME() {
		return LAST_NAME;
	}

	public static void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}

	public static String getGENDER() {
		return GENDER;
	}

	public static void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public static String getADDRESS() {
		return ADDRESS;
	}

	public static void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public static String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}

	public static void setPHONE_NUMBER(String pHONE_NUMBER) {
		PHONE_NUMBER = pHONE_NUMBER;
	}

	public static String getBLOOD_TYPE() {
		return BLOOD_TYPE;
	}

	public static void setBLOOD_TYPE(String bLOOD_TYPE) {
		BLOOD_TYPE = bLOOD_TYPE;
	}

	public static String getCONTACT_PERSON_NAME() {
		return CONTACT_PERSON_NAME;
	}

	public static void setCONTACT_PERSON_NAME(String cONTACT_PERSON_NAME) {
		CONTACT_PERSON_NAME = cONTACT_PERSON_NAME;
	}

	public static String getCONTACT_PERSON_EMAIL() {
		return CONTACT_PERSON_EMAIL;
	}

	public static void setCONTACT_PERSON_EMAIL(String cONTACT_PERSON_EMAIL) {
		CONTACT_PERSON_EMAIL = cONTACT_PERSON_EMAIL;
	}

	public static double getIMPACT_POW() {
		return IMPACT_POW;
	}

	public static void setIMPACT_POW(double iMPACT_POW) {
		IMPACT_POW = iMPACT_POW;
	}

	public static int getIMPACT_PASS() {
		return IMPACT_PASS;
	}

	public static void setIMPACT_PASS(int iMPACT_PASS) {
		IMPACT_PASS = iMPACT_PASS;
	}

	public static double getLAYING_POW() {
		return LAYING_POW;
	}

	public static void setLAYING_POW(double lAYING_POW) {
		LAYING_POW = lAYING_POW;
	}

	public static int getSKIP_MEASURE() {
		return SKIP_MEASURE;
	}

	public static void setSKIP_MEASURE(int sKIP_MEASURE) {
		SKIP_MEASURE = sKIP_MEASURE;
	}

	public static double getFALL_ANGLE() {
		return FALL_ANGLE;
	}

	public static void setFALL_ANGLE(double fALL_ANGLE) {
		FALL_ANGLE = fALL_ANGLE;
	}

	public static int getHELP_REQUEST_DELAY() {
		return HELP_REQUEST_DELAY;
	}

	public static void setHELP_REQUEST_DELAY(int hELP_REQUEST_DELAY) {
		HELP_REQUEST_DELAY = hELP_REQUEST_DELAY;
	}

}