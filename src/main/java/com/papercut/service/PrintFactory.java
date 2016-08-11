package com.papercut.service;

import com.papercut.business.PrintAnalyserService;
import com.papercut.business.PrintAnalyserServiceImpl;

public class PrintFactory {
	
	/**
	 * Factory responsible for generating the PrintAnalyserService
	 * @return
	 */
    public static PrintAnalyserService getServiceBean() {
        return new PrintAnalyserServiceImpl();
    }

}
