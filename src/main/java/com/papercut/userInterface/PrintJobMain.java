package com.papercut.userInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.papercut.exception.InvalidJobDataException;
import com.papercut.exception.JobFileReaderException;
import com.papercut.service.PrintAnalyserDelegate;

public class PrintJobMain {
	
	private static String message = "Please enter the csv file path : e.g. C:/temp/PrintJob.csv : ";
	private static BufferedReader pathStrReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
    	System.out.println("\n ------   PaperCut Print Job Analyser   ------");
    	PrintJobMain printJobMain = new PrintJobMain();
    	printJobMain.callPrinting();
    }
    
    
    private void callPrinting(){
    	
    	String path = "";
        PrintAnalyserDelegate analyserDelegate = new PrintAnalyserDelegate();
        String finalReceipt = "";
        
        try {
        	path = readPath(message);
        	finalReceipt = analyserDelegate.printJob(path);
        	System.out.println(finalReceipt);
            System.out.println("\n ------     Job ended successfully     ------");
        } catch (JobFileReaderException jfre) {
        	System.out.print("------   Error reading .csv file    ------");
        } catch(InvalidJobDataException ije){
        	System.out.print("------   Error in .csv file data    ------");
        } catch (ArrayIndexOutOfBoundsException nfe) {
			System.out.print("------   Error in .csv file data    ------");
		} catch (RuntimeException rte) {
			System.out.print("Unexpected Error : " + rte.toString());
		} catch (Exception ex) {
            System.out.print("Unexpected Error : " + ex.toString());
        } finally{
        	try {
				pathStrReader.close();
			} catch (Exception e) {
				System.out.print("Error : " + e.getMessage());
			}
        }
    }
    
    
    public static String readPath(final String prompt){
    	String path = "";
    	
        try {
            System.out.println();
            System.out.print(prompt);
            path = pathStrReader.readLine().trim();
            
        } catch (IOException ioe) {
        	System.out.print("Unexpected Error : " + ioe.toString());
        }
        return path;
    }
}
