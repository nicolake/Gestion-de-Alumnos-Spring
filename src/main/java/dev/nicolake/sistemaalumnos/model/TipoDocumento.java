package dev.nicolake.sistemaalumnos.model;

public enum TipoDocumento {
    DNI("DNI"),
    CIVIC("Libreta Civica");

    private final String displayValue;

    private TipoDocumento(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
