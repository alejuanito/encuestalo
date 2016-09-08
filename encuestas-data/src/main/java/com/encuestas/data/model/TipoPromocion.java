package com.encuestas.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.encuestas.data.bean.TipoPromocionBean;


@Entity
@Table(name = "ectm_tipo_promocion")
public class TipoPromocion {
	private Integer idTipoPromocion;
	private String deTipoPromocion;
	
	public TipoPromocion() {
	}

	public TipoPromocion(TipoPromocionBean tipoPromocionBean) {
		this.idTipoPromocion = tipoPromocionBean.getIdTipoPromocion();
		this.deTipoPromocion = tipoPromocionBean.getDeTipoPromocion();
		
	}
	
	@Id
	@Column(name = "id_tipo_promocion")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdTipoPromocion() {
		return idTipoPromocion;
	}


	public void setIdTipoPromocion(Integer idTipoPromocion) {
		this.idTipoPromocion = idTipoPromocion;
	}

	@Column(name = "de_tipo")
	public String getDeTipoPromocion() {
		return deTipoPromocion;
	}


	public void setDeTipoPromocion(String deTipoPromocion) {
		this.deTipoPromocion = deTipoPromocion;
	}	


	

	
	
	
}
