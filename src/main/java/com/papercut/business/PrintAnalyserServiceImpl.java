package com.papercut.business;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.papercut.business.paper.PrintableObjectFactory;
import com.papercut.business.paper.PaperType;
import com.papercut.business.paper.PrintableObject;
import com.papercut.domain.PrintJob;
import com.papercut.exception.InvalidJobDataException;
import com.papercut.exception.JobFileReaderException;
import com.papercut.util.JobFileReader;
import com.papercut.util.PrintUtil;

public class PrintAnalyserServiceImpl implements PrintAnalyserService {

    @Override
    public String analysePrintJob(String filePath) throws InvalidJobDataException, JobFileReaderException{
    	
    	List<PrintJob> printJobs = readAndRetrievePrintJobs(filePath);
    	if(printJobs == null || printJobs.size() == 0){
    		return "------   No jobs to print   ------";
    	}
    	return processPrintJobs(printJobs);
    }


    /**
     * Reads the .csv file at the location in the give path and constructs a List of type PrintJob
     * @param filePath
     * @return List<PrintJob>
     */
	public List<PrintJob> readAndRetrievePrintJobs(String filePath) throws InvalidJobDataException, JobFileReaderException {
		List<PrintJob> printJobs = new ArrayList<PrintJob>();
    	JobFileReader jobFileReader = new JobFileReader();
        final File jobFile = new File(filePath);
        
        if(!jobFile.exists()){
        	throw new JobFileReaderException("Invalid file ", new FileNotFoundException());
        }
        
        List<String> printJobsFromCsv = jobFileReader.readJobFile(jobFile);
        
        for (Iterator<String> iterator = printJobsFromCsv.iterator(); iterator.hasNext();) {
			String printJobStr = (String) iterator.next();
			
	        String[] printJobArr = printJobStr.split(PrintUtil.splitter);
	        if(printJobArr != null && printJobArr.length != 0){
	        	if(PrintUtil.isNotEmpty(printJobArr[0]) || PrintUtil.isNotEmpty(printJobArr[1]) || PrintUtil.isNotEmpty(printJobArr[2])){
	        		if(PrintUtil.isNumeric(printJobArr[0]) && PrintUtil.isNumeric(printJobArr[1]) && PrintUtil.isBoolean(printJobArr[2])){
	        			
	        			PrintJob job = new PrintJob(Integer.valueOf(printJobArr[0]), Integer.valueOf(printJobArr[1]), Boolean.valueOf(printJobArr[2]));
	        			printJobs.add(job);
	        		}else {
	        			throw new InvalidJobDataException("invalidData", new NumberFormatException());
	        		}		        	
		        }else{
		        	throw new InvalidJobDataException("invalidData", new NullPointerException());
		        }
	        }
		}
        return printJobs;
	}
    
	
	/**
	 * Performs the print job for the supplied PrintJobs and constructs the final billing sting
	 * @param printJobs
	 * @return String
	 */
	public String processPrintJobs(List<PrintJob> printJobs) {
		Double totalSum = 0.0;
		StringBuffer finalString = new StringBuffer();
		for (PrintJob printJob : printJobs) {
			PrintableObjectFactory factory = new PrintableObjectFactory();
			PrintableObject a4paer = factory.buildPrintableObject(PaperType.A4.getDescription(), printJob);
			finalString.append(a4paer.printResults());
			String lineTotal = a4paer.printResults().substring(a4paer.printResults().lastIndexOf("= ")+2, a4paer.printResults().lastIndexOf("\n"));
			totalSum += Double.valueOf(lineTotal);
		}
		finalString.append("\n----------------------");
		finalString.append("\n Final total = ").append(PrintUtil.formatCost(totalSum));
		finalString.append("\n----------------------");

		return finalString.toString();
	}
}
