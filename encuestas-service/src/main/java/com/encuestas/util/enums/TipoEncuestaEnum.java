package com.encuestas.util.enums;

public enum TipoEncuestaEnum {
    ATENCION("ATEN");
    
    private final String codigo;
    
    private TipoEncuestaEnum (String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

}
