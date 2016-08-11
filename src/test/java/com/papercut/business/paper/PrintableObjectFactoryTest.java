package com.papercut.business.paper;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import com.papercut.business.paper.A4Paper;
import com.papercut.business.paper.PaperType;
import com.papercut.business.paper.PrintableObject;
import com.papercut.business.paper.PrintableObjectFactory;
import com.papercut.domain.PrintJob;

public class PrintableObjectFactoryTest {

	@Test
	public void test_TestProntJobOfTypeA4FactoryisCalled_ShouldReturnObjectOfTypeA4Paper(){
		/*
		 * Given = A Test ProntJob Of Type A4
		 */
		PrintJob job = new PrintJob(25,10,false);
		String paperType = PaperType.A4.getDescription();
		
		/*
		 * When = Factory is Called
		 */
		PrintableObjectFactory factory = new PrintableObjectFactory();
		PrintableObject a4paer = factory.buildPrintableObject(paperType, job);
		
		/*
		 * Then = Should Return an Object of the Type A4Paper
		 */
        assertThat(a4paer).isNotNull();
        assertThat(a4paer).isExactlyInstanceOf(A4Paper.class);
	}
}
