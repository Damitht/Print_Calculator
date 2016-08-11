package com.papercut.business.paper;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.papercut.business.charges.A4PrintCharges;
import com.papercut.business.paper.A4Paper;
import com.papercut.domain.PrintJob;

public class A4PaperTest {
	
	@Test
	public void test_A4PaperSingleSided_CalculatePrintCost_ReturnCorrectCost(){
		/*
		 * Given = A4 paper single sided
		 */
		A4Paper a4Paper = new A4Paper(new PrintJob(25, 10, false), new A4PrintCharges()) ;
		
		/*
		 * When = Calculate Print Cost
		 */
		double jobCost = a4Paper.calculatePrintCost();
		
		/*
		 * Then = Correct print cost is returned
		 */
		assertThat(jobCost).isEqualTo(4.75);
	}
	
	@Test
	public void test_A4PaperDoubleSided_CalculatePrintCost_ReturnCorrectCost(){
		/*
		 * Given = A4 paper single sided
		 */
		A4Paper a4Paper = new A4Paper(new PrintJob(55, 13, true), new A4PrintCharges()) ;
		
		/*
		 * When = Calculate Print Cost
		 */
		double jobCost = a4Paper.calculatePrintCost();
		
		/*
		 * Then = Correct print cost is returned
		 */
		assertThat(jobCost).isEqualTo(13.600000000000001);
	}
	

}