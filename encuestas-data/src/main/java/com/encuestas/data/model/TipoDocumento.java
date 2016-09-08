package com.encuestas.data.model;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ectm_tipo_documento")
public class TipoDocumento {
	private String coTipoDocumento;
	private String deLarga;
	private String deCorto;

	@Id
	@Column(name = "co_tipo_documento")
	public String getCoTipoDocumento() {
		return coTipoDocumento;
	}

	@Column(name = "de_larga")
	public String getDeLarga() {
		return deLarga;
	}

	public void setDeLarga(String deLarga) {
		this.deLarga = deLarga;
	}

	@Column(name = "de_corto")
	public String getDeCorto() {
		return deCorto;
	}

	public void setDeCorto(String deCorto) {
		this.deCorto = deCorto;
	}

	public void setCoTipoDocumento(String coTipoDocumento) {
		this.coTipoDocumento = coTipoDocumento;
	}

	

}
