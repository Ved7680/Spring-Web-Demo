package com.util;

public class Validators {
	public static boolean isBlank(String data) {
		if (data == null || data.trim().length() == 0 || data.equals("-1") == true) {
			return true;
		}else{
			return false;
		}
	} // end of isBlank()
	
	
	public static boolean isAlpha(String data) {
		String alphaRegEx = "[a-zA-Z]+";
		return data.matches(alphaRegEx);
	} // end of isAlpha()
	
	public static boolean isEmail(String data) {
		String emailRegEx = "[a-z@.A-Z0-9]+";
		return data.matches(emailRegEx);
	} // end of isEmail()
	
	public static boolean isAlphaNumeric(String data) {
		String alphaRegEx = "[a-zA-Z0-9]+";
		return data.matches(alphaRegEx);
	} // end of isAlpha()
	
	
}
