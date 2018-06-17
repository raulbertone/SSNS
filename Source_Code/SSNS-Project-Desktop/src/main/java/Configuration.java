/**
 * 
 * 
 * @author Raul Bertone
 */


public class Configuration {

	// User data
	private static String firstName = "Jane";
	private static String lastName = "Doe";
	private static String birthDate = "1/1/1900";
	private static String gender = "F";
	private static String address = "Park Lane 7, New York City, NY";
	private static String mobileNumber = "555-123456";
	private static String bloodType = "AB";
	
	// helper data
	private static String helperFirstName = "John";
	private static String helperLastName = "Doe";
	private static String helperEmail = "john.doe@does.com";
	
	// calibration data
	
	
	public static String getFirstName() {
		return firstName;
	}
	public static String getHelperFirstName() {
		return helperFirstName;
	}
	public static void setHelperFirstName(String helperFirstName) {
		Configuration.helperFirstName = helperFirstName;
	}
	public static String getHelperLastName() {
		return helperLastName;
	}
	public static void setHelperLastName(String helperLastName) {
		Configuration.helperLastName = helperLastName;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		Configuration.email = email;
	}
	public static void setFirstName(String firstName) {
		Configuration.firstName = firstName;
	}
	public static String getLastName() {
		return lastName;
	}
	public static void setLastName(String lastName) {
		Configuration.lastName = lastName;
	}
	public static String getBirthDate() {
		return birthDate;
	}
	public static void setBirthDate(String birthDate) {
		Configuration.birthDate = birthDate;
	}
	public static String getGender() {
		return gender;
	}
	public static void setGender(String gender) {
		Configuration.gender = gender;
	}
	public static String getAddress() {
		return address;
	}
	public static void setAddress(String address) {
		Configuration.address = address;
	}
	public static String getMobileNumber() {
		return mobileNumber;
	}
	public static void setMobileNumber(String mobileNumber) {
		Configuration.mobileNumber = mobileNumber;
	}
	public static String getBloodType() {
		return bloodType;
	}
	public static void setBloodType(String bloodType) {
		Configuration.bloodType = bloodType;
	}
}
