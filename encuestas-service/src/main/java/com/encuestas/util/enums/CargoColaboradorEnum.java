package com.encuestas.util.enums;

public enum CargoColaboradorEnum {
    MOZO("MZ"),
    ENCUESTADOR("EC"),
    ADMIN("AD");
    
    private final String codigo;
    
    private CargoColaboradorEnum (String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

}
