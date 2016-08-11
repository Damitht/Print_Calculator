package com.papercut.util;

import java.text.DecimalFormat;

public class PrintUtil {
	
	public static final String splitter = ",";
	public static final String format = "#0.00";

	/**
	 * Checks is a given String is empty
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return str == null || trimSpaces(str).equals("") ? true:false;
	}
	
	
	/**
	 * Checks is a given String is NOT empty
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	
	
	/**
	 * Checks is a given String is numeric
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
		try{  
			Double.parseDouble(trimSpaces(str));
		}catch(NumberFormatException nfe){  
			return false;
		}  
		return true;  
	}
	
	
	/**
	 * Checks is a given String is boolean
	 * @param str
	 * @return
	 */
	public static boolean isBoolean(String str){
		return trimSpaces(str).equals("true") || trimSpaces(str).equals("false")? true : false;
	}
	
	
	/**
	 * Formats a string 
	 * @param value
	 * @return
	 */
    public static String formatCost(double value) {
        DecimalFormat formatter = new DecimalFormat(format);
        return formatter.format(value);
    }
    
    
    /**
     * Trims spaces of a string
     * @param str
     * @return
     */
    public static String trimSpaces(String str){

    	return str.replaceAll("\\s","").trim();
    }
}
