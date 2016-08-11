package com.papercut.business.paper;

public enum PaperType {
	
    A4("A4"), A3("A3");

    private String description;

    PaperType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
