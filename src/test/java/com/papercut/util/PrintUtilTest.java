package com.papercut.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PrintUtilTest {
	
	@Test
	public void test_IsEmpty(){
		/*
		 * Given Empty String
		 */
		String emptyString = "";
		/* When isEmpty is called
		 * 
		 */
		boolean result = PrintUtil.isEmpty(emptyString);
		/* 
		 * Then should return true
		 */
		assertThat(result).isEqualTo(true);
	}
	
	
	@Test
	public void test_IsNotEmpty(){
		/*
		 * Given Not Empty String
		 */
		String emptyString = "Papercut";
		/* When isEmpty is called
		 * 
		 */
		boolean result = PrintUtil.isNotEmpty(emptyString);
		/* 
		 * Then should return true
		 */
		assertThat(result).isEqualTo(true);
	}
	
	
	@Test
	public void test_IsBoolean(){
		/*
		 * Given string "true"
		 */
		String boolString = "true";
		/* When isEmpty is called
		 * 
		 */
		boolean result = PrintUtil.isBoolean(boolString);
		/* 
		 * Then should return true
		 */
		assertThat(result).isEqualTo(true);
	}
	
	
	@Test
	public void test_formatDecimal(){
		/*
		 * Given string "13.6000000001"
		 */
		double val = 13.6000000001;
		
		/* When formatCost is called
		 * 
		 */
		String str = PrintUtil.formatCost(val);
		/* 
		 * Then should return true
		 */
		assertThat(str).isEqualTo("13.60");
	}
	
	
	@Test
	public void test_IsNumeric(){
		/*
		 * Given string "13.600N000001"
		 */
		String val = "13.600N000001";
		
		/* When isNumeric is called
		 * 
		 */
		boolean bool = PrintUtil.isNumeric(val);
		/* 
		 * Then should return false
		 */
		assertThat(bool).isEqualTo(false);
	}

}
