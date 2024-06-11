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
		String alphaRegEx = "[a-z A-Z]+";
		return data.matches(alphaRegEx);
	} // end of isAlpha()
}
