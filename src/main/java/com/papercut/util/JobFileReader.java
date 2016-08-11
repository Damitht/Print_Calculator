package com.papercut.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.papercut.exception.JobFileReaderException;

public class JobFileReader {

	/**
	 * Reads a .csv file in the given path and returns a List of Stings.
	 * One element in the List represents a line in the .csv file
	 * @param file
	 * @return
	 */
    public List<String> readJobFile(File file) throws JobFileReaderException{
        final List<String> printJobs = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(file);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
        	
        	String sCurrentLine;
        	while ((sCurrentLine = bufferedReader.readLine()) != null) {
        		String tempStr = sCurrentLine.replaceAll("\\s+","");
        		printJobs.add(tempStr);
			}

        } catch (IOException e) {
            throw new JobFileReaderException("Error reading csv file", e);
        }

        return printJobs;
    }
	
}
