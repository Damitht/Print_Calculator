package com.papercut.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;
import com.papercut.domain.PrintJob;
import com.papercut.util.StaticTestData;

public class PrintAnalyserServiceImplTest {
	
	@Test
	public void test_CorrectPath_ReadAndRetrievePrintJobs_SizeAndElementsShouldBeEqualToTestData(){
		/*
		 * Give = Correct Path
		 */
		String path = StaticTestData.filePath;
		
		/*
		 * When = Read And Retrieve Print Jobs
		 */
	
		PrintAnalyserServiceImpl analyserServiceImpl = new PrintAnalyserServiceImpl();
		List<PrintJob> jobList =  analyserServiceImpl.readAndRetrievePrintJobs(path);
		
		List<PrintJob> testData = StaticTestData.populateTestPrintJobs();
		
		/*
		 * Then Size and Elements Should Be Equal to Test Data
		 */
		assertThat(jobList.size()).isEqualTo(4);
        assertThat(testData.equals(jobList));
	}
	
	
	@Test
	public void test_TestData_CalculatingPrintJobCostGrandTotal_ShouldbeEqualtoActualValue(){
		/*
		 * Given = Test Data
		 */
		List<PrintJob> testData = StaticTestData.populateTestPrintJobs();
		
		/*
		 * When Calculating Print Job Cost Grand Total
		 */
		PrintAnalyserServiceImpl analyserServiceImpl = new PrintAnalyserServiceImpl();
		String resultStr =  analyserServiceImpl.processPrintJobs(testData);
		Double finalTotal = Double.valueOf(resultStr.substring(resultStr.lastIndexOf("=")+1, resultStr.lastIndexOf("\n")));
		
		/*
		 * Should be Equal to Actual Value
		 */
		assertThat(finalTotal.equals(123.30));
	}

}
