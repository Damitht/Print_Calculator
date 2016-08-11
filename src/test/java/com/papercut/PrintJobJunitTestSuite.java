package com.papercut;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.papercut.business.PrintAnalyserServiceImplTest;
import com.papercut.business.paper.A4PaperTest;
import com.papercut.business.paper.PrintableObjectFactoryTest;
import com.papercut.domain.PrintJobTest;
import com.papercut.service.PrintAnalyserDelegateTest;
import com.papercut.util.JobFileReaderTest;
import com.papercut.util.PrintUtilTest;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	PrintableObjectFactoryTest.class,
	A4PaperTest.class,
	PrintAnalyserServiceImplTest.class,
	PrintJobTest.class,
	PrintAnalyserDelegateTest.class,
	JobFileReaderTest.class,
	PrintUtilTest.class
})
public class PrintJobJunitTestSuite {   
} 