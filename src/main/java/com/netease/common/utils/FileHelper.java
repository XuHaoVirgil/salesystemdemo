package com.netease.common.utils;

import java.io.File;

public class FileHelper {

	public final static String getFileExtention(String fileName){
		if(TextUtil.isEmptyWithoutTrim(fileName)) {
			return "";
		}
		
		int lastDotIndex = fileName.lastIndexOf('.');
		if(lastDotIndex < 0) {
			return "";
		}
		
		return fileName.substring(lastDotIndex);
	}
	
	public final static void createDiretory(String dir){
		File file = new File(dir);
		if(file.exists() == false){
			file.mkdirs();
			return ;
		}
		
		if(file.isDirectory() == false) {
			file.delete();
			file.mkdirs();
			return ;
		}
	}
}
