package com.papercut.domain;

/**
 * 
 * POJO class to hold PintJob details representing the domain object of the case
 *
 */
public class PrintJob {
	
	public PrintJob(int totalPages, int colouredPages, boolean doubleSided){
		this.totalPages = totalPages;
		this.colouredPages = colouredPages;
		this.doubleSided = doubleSided;
	}
	
	private int totalPages;
	private int colouredPages;
	private boolean doubleSided;
	
	public int getTotalPages() {
		return totalPages;
	}

	public int getColouredPages() {
		return colouredPages;
	}

	public boolean isDoubleSided() {
		return doubleSided;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrintJob obj = (PrintJob) o;

        if (totalPages != obj.totalPages) return false;
        if (colouredPages != obj.colouredPages) return false;
        if (doubleSided != obj.doubleSided) return false;

        return true;

    }
}
