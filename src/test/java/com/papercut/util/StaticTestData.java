package com.papercut.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.papercut.domain.PrintJob;

public class StaticTestData {
	
	public static String filePath = "C:/Damith/Per/Achieve/Interview/PaperCut/printjobs.csv";
	public static List<String> testDataList = Arrays.asList("25,10,false", "55,13,true", "502,22,true", "1,0,false");

	public static List<PrintJob> populateTestPrintJobs() {
		List<PrintJob> testData = new ArrayList<PrintJob>();
		
		testData.add(new PrintJob(25, 10, false));
		testData.add(new PrintJob(55, 13, true));
		testData.add(new PrintJob(502, 22, true));
		testData.add(new PrintJob(1, 0, false));
		return testData;
	}
	
}
