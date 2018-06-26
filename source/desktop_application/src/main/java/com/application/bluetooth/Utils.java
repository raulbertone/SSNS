package com.application.bluetooth;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.io.BaseEncoding;

public class Utils {

	
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
	 
	 
	 public static  String reverseHexString(String data)
	 {
	 	byte[] dataB = BaseEncoding.base16().decode(data);
	 	ArrayUtils.reverse(dataB);
	 	return BaseEncoding.base16().encode(dataB);
	 	
	 }
}
