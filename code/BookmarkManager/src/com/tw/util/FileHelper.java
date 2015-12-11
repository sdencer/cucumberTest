package com.tw.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHelper {
	public static String readFile(String path) {  
	      File file = new File(path);  
	      BufferedReader reader = null;  
	      String laststr = "";  
	      try {  
	          reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));  
	          String tempString = null;  
	          while ((tempString = reader.readLine()) != null) {  
	              laststr = laststr + tempString;  
	          }  
	          reader.close();  
	      } catch (IOException e) {  
	          e.printStackTrace();  
	      } finally {  
	          if (reader != null) {  
	              try {  
	                  reader.close();  
	              } catch (IOException e1) {  
	              }  
	          }  
	      }  
	      return laststr;  
	}  
}
