package com.papercut.business.paper;

import com.papercut.business.charges.PrintCharges;
import com.papercut.domain.PrintJob;
import com.papercut.util.PrintUtil;

public class A4Paper extends Paper implements PrintableObject{

	/**
	 * A4Paper must contain a PrintJob as well as a PrintCharges to execute correctly. 
	 * @param printJob
	 * @param printCharges
	 */
    public A4Paper(PrintJob printJob, PrintCharges printCharges) {
		super(printJob, printCharges);
	}

    /**
     * Calculates the print cost based on single or double side property of the paper
     */
	@Override
    public double calculatePrintCost() {
    	double charge = 0;
    	if(getPrintJob().isDoubleSided()){
    		charge = ((getPrintJob().getTotalPages() - getPrintJob().getColouredPages()) * getPrintCharges().blackNWhiteDoubleCharge() * 2)
    				+getPrintJob().getColouredPages() * getPrintCharges().coloredDoubleCharge() * 2;
    	}else{
    		charge = ((getPrintJob().getTotalPages() - getPrintJob().getColouredPages()) * getPrintCharges().blackNWhiteSingleCharge())
    				+ (getPrintJob().getColouredPages() * getPrintCharges().coloredSingleCharge());
    	}
    	
        return charge;
    }


	/**
	 * Constructs the Stringbuffer with all billing information 
	 */
    @Override
    public StringBuffer printResults() {
        StringBuffer strBuffer = new StringBuffer("\n -------- Printing Job Details -------");
        strBuffer.append("\n Paper size = A4 ");
        
        if(getPrintJob().isDoubleSided()){
        	strBuffer.append("\n Double sided job ");
        	strBuffer.append("\n (No of coloured pages * rate * 2) + (No of black and white * rate * 2)");
        	strBuffer.append("\n ( ").append(getPrintJob().getColouredPages()).append(" * ").append(getPrintCharges().coloredDoubleCharge()).append(" * 2 ) + ( ");
        	strBuffer.append(getPrintJob().getTotalPages() - getPrintJob().getColouredPages()).append(" * ").append(getPrintCharges().blackNWhiteDoubleCharge()).append(" * 2 )");
        }else{
        	strBuffer.append("\n Single sided job ");
        	strBuffer.append("\n (No of coloured pages * rate) + (No of black and white * rate)");
        	strBuffer.append("\n ( ").append(getPrintJob().getColouredPages()).append(" * ").append(getPrintCharges().coloredSingleCharge()).append(" ) + ( ");
        	strBuffer.append(getPrintJob().getTotalPages() - getPrintJob().getColouredPages()).append(" * ").append(getPrintCharges().blackNWhiteSingleCharge()).append(" )");
        }
        strBuffer.append("\n Job Total = ").append(PrintUtil.formatCost(calculatePrintCost()));
        strBuffer.append("\n");
        return strBuffer;
    }

}
