package com.papercut.service;

import com.papercut.business.PrintAnalyserService;
import com.papercut.exception.InvalidJobDataException;

public class PrintAnalyserDelegate {
	
	/**
	 * 
	 * @return PrintAnalyserService
	 */
	public PrintAnalyserService getPrintService() {
		return PrintFactory.getServiceBean();
	}

	public String printJob(String path) throws InvalidJobDataException{
		PrintAnalyserService printService = getPrintService();
		return printService.analysePrintJob(path);
	}
}
