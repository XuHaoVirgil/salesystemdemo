package com.netease.common.utils;

public class TextUtil {
	
	public final static boolean isEmptyWithTrim(String text) {
		if(text == null || "".equals(text.trim())) {
			return true;
		}
		
		return false;
	}

	public final static boolean isEmptyWithoutTrim(String text) {
		if(text == null || "".equals(text)) {
			return true;
		}
		
		return false;
	}
	
	public final static boolean isEqual(String str1, String str2) {
		if(str1 != null) {
			return str1.equals(str2);
		} else {
			return str1 == str2;
		}
	}
	
	public final static String trim(String value){
		if(value != null) {
			return value.trim();
		}
		
		return value;
	}
}
