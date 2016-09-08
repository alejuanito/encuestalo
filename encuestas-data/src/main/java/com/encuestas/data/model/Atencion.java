package com.encuestas.data.model;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name = "ectm_atencion")
public class Atencion {
	private Integer idAtencion;	
	private Integer nuMesa;
	private Colaborador colaborador;
	private Area area;
	
	
	@Id
	@SequenceGenerator(name="ectm_atencion_id_atencion_seq", sequenceName="ectm_atencion_id_atencion_seq", allocationSize=1)
	@Column(name = "id_atencion")	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ectm_atencion_id_atencion_seq")
	public Integer getIdAtencion() {
		return idAtencion;
	}

	public void setIdAtencion(Integer idAtencion) {
		this.idAtencion = idAtencion;
	}

	@Column(name = "nu_mesa")
	public Integer getNuMesa() {
		return nuMesa;
	}

	public void setNuMesa(Integer nuMesa) {
		this.nuMesa = nuMesa;
	}

	@ManyToOne
	@JoinColumn(name = "id_colaborador")
	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	@ManyToOne
	@JoinColumn(name = "id_area")
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	

	
	
	
	
}
