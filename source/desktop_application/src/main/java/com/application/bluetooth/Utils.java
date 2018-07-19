package com.application.bluetooth;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.io.BaseEncoding;

public class Utils {

	/**
	 * @author Elis
	 * 
	 * Method to convert a hex value to int value
	 * 
	 * @param String s 
	 * 
	 * @return int val
	 * Example 
	 * 
	 * Utils.hex2decimal("FF00");
	 * */
	 public static int hex2decimal(String s) {
	        String digits = "0123456789ABCDEF";
	        s = s.toUpperCase();
	        int val = 0;
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            int d = digits.indexOf(c);
	            val = 16*val + d;
	        }
	        return val;
	    }
	 
	 /**
	  * @author Elis
	  * 
	  * method to reverse the hexadecimal string because we get the low parity bit first
	  * 
	  * @param String data
	  * @return String reverseString
	  * */
	 public static  String reverseHexString(String data)
	 {
	 	byte[] dataB = BaseEncoding.base16().decode(data);
	 	ArrayUtils.reverse(dataB);
	 	return BaseEncoding.base16().encode(dataB);
	 	
	 }
}
