package com.papercut.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.List;

import org.junit.Test;


public class JobFileReaderTest {

	@Test
	public void test_CorrectPath_ReadAndRetrievePrintJobs_SizeAndElementsShouldBeEqualToTestData(){
		/*
		 * Given = Correct Path
		 */
		String filePath = StaticTestData.filePath;
		
		/*
		 * When = Read And Retrieve Print Jobs
		 */
		JobFileReader fileReader = new JobFileReader();
		final File jobFile = new File(filePath);
		List<String> jobListString =  fileReader.readJobFile(jobFile);
		
		/*
		 * Then Size and Elements Should Be Equal to Test Data
		 */
        assertThat(jobListString.size()).isEqualTo(4);
        assertThat(jobListString).containsAll(StaticTestData.testDataList);
	}
}