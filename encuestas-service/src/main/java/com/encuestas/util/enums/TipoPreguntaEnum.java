package com.encuestas.util.enums;

public enum TipoPreguntaEnum {
    CERRADA("CERR"),
    ABIERTA("ABIE");
    
    private final String codigo;
    
    private TipoPreguntaEnum (String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

}
