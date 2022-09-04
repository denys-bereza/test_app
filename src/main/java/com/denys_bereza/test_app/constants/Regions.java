package com.denys_bereza.test_app.constants;

// Regions.EAST_EUROPE.getName();
public enum Regions {
    EAST_EUROPE("EAST_EUROPE"),
    WEST_EUROPE("WEST_EUROPE"),

    NORTH_AMERICA("NORTH_AMERICA"),
    SOUTH_AMERICA("SOUTH_AMERICA"),

    NORTH_AFRICA("NORTH_AFRICA"),
    SOUTH_AFRICA("SOUTH_AFRICA"),

    EAST_ASIA("EAST_ASIA"),
    WEST_ASIA("WEST_ASIA"),

    OCEANIA("OCEANIA");

    private final String name;
    Regions(final String text) {
        this.name = text;
    }

    @Override
    public String toString() {
        return name;
    }
}
