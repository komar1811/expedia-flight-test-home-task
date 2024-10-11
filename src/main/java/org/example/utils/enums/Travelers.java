package org.example.utils.enums;

public enum Travelers {
    ADULTS("Adults"),
    CHILDREN("Children"),
    INFANTS_ON_LAP("Infants on lap"),
    INFANTS_ON_SEAT("Infants in seat");

    public final String label;

    private Travelers(String label) {
        this.label = label;
    }

}
