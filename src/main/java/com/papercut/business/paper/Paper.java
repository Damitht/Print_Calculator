package com.papercut.business.paper;

import com.papercut.business.charges.PrintCharges;
import com.papercut.domain.PrintJob;

public abstract class Paper{

	private PrintJob printJob;
	private PrintCharges printCharges;
	
	public Paper(PrintJob printJob, PrintCharges printCharges){
		this.printJob = printJob;
		this.printCharges = printCharges;
	}

	public PrintJob getPrintJob() {
		return printJob;
	}

	public PrintCharges getPrintCharges() {
		return printCharges;
	}
}
