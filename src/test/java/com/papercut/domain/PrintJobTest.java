package com.papercut.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PrintJobTest {
	
	@Test
	public void test_EqualMethodTrue(){
		/*
		 * Given = Two equal objects
		 */
		PrintJob job1 = new PrintJob(10, 15, true);
		PrintJob job2 = new PrintJob(10, 15, true);
		
		/*
		 * When = PrintJob.euqlas method is called
		 */
		boolean result = job1.equals(job2);
		
		/*
		 * Then = Should return true
		 */
		assertThat(result).isEqualTo(true);
	}

	@Test
	public void test_EqualMethodFalse(){
		/*
		 * Given = Two not equal objects
		 */
		PrintJob job1 = new PrintJob(10, 15, true);
		PrintJob job2 = new PrintJob(10, 15, false);
		
		/*
		 * When = PrintJob.euqlas method is called
		 */
		boolean result = job1.equals(job2);
		
		/*
		 * Then = Should return false
		 */
		assertThat(result).isEqualTo(false);
	}
}
