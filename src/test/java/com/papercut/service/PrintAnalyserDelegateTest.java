package com.papercut.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.papercut.business.PrintAnalyserService;
import com.papercut.business.PrintAnalyserServiceImpl;

public class PrintAnalyserDelegateTest {

	@Test
	public void test_CalledGetPrintService_ReturnObjectofTypePrintAnalyserServiceImpl(){
	
		/*
		 * When = The getPrintService is Called
		 */
        PrintAnalyserDelegate analyserDelegate = new PrintAnalyserDelegate();
		
		/*
		 * Then = Should Return an Object of Type PrintAnalyserServiceImpl
		 */
        PrintAnalyserService printService = analyserDelegate.getPrintService();
        assertThat(printService).isNotNull();
        assertThat(printService).isExactlyInstanceOf(PrintAnalyserServiceImpl.class);
	}
}
