package com.patient.enums;

public enum IdentityType {
    VI("Voter ID"),
    DL("Driving License"),

    ADH("Aadhar Card"),
    PC("Pan Card");


    private String value;

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }


    IdentityType(String value) {
        this.value = value;
    }
}
