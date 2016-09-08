package com.encuestas.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.encuestas.data.bean.MotivoPromocionBean;

@Entity
@Table(name = "ectm_motivo_promocion")
public class MotivoPromocion {
	private Integer idMotivoPromocion;
	private String deMotivoPromocion;

	public MotivoPromocion() {
	}

	public MotivoPromocion(MotivoPromocionBean motivoPromocionBean) {
		this.idMotivoPromocion = motivoPromocionBean.getIdMotivoPromocion();
		this.deMotivoPromocion = motivoPromocionBean.getDeMotivoPromocion();
		
	}

	@Id
	@Column(name = "id_motivo_promocion")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdMotivoPromocion() {
		return idMotivoPromocion;
	}

	public void setIdMotivoPromocion(Integer idMotivoPromocion) {
		this.idMotivoPromocion = idMotivoPromocion;
	}

	@Column(name = "de_motivo")
	public String getDeMotivoPromocion() {
		return deMotivoPromocion;
	}

	public void setDeMotivoPromocion(String deMotivoPromocion) {
		this.deMotivoPromocion = deMotivoPromocion;
	}

}
