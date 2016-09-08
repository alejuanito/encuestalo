package com.encuestas.util.enums;

public enum EstadoEnum {
	ACTIVO("A"),
	INACTIVO("I");

	private final String codigo;
	
	private EstadoEnum (String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo () {
		return codigo;
	}
}
