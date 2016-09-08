package com.encuestas.data.model;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name = "ectm_area")
public class Area {
	private Integer idArea;
	private Local local;
	private String deArea;


	@Id
	@Column(name = "id_area")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdArea() {
		return idArea;
	}

	@ManyToOne
	@JoinColumn(name = "id_local")
	public Local getLocal() {
		return local;
	}

	
	
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	@Column(name = "de_area")
	public String getDeArea() {
		return deArea;
	}

	public void setDeArea(String deArea) {
		this.deArea = deArea;
	}
	
	
	
}
