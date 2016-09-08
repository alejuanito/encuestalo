package com.encuestas.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.encuestas.data.bean.PlantillaEncuestaPreguntaBean;

/**
 * Created by JaxKodex on 29/11/2015.
 */
@Entity
@Table(name = "ectd_plantilla_encuesta")
public class PlantillaEncuestaPregunta {
	private Integer idPlantillaEncuestaDetalle;
	private PlantillaEncuesta plantillaEncuesta;
	private Integer nuOrden;
	private String dePregunta;
	private String coTipoPregunta;
	private String estado;
	private Date feCreaRegistro;
	private Integer idCreaRegistro;
	private Date feModRegistro;
	private Integer idModRegistro;
	private Boolean inEsRptaCorta;
	private List<PlantillaEncuestaRespuesta> plantillaEncuestaRespuestas;
	
	@PrePersist
	public void prePersist () {
		this.feCreaRegistro = new Date();
	}
	
	@PreUpdate
	public void preUpdate () {
		this.feModRegistro = new Date();
	}

	public PlantillaEncuestaPregunta() {
	}

	public PlantillaEncuestaPregunta(Integer id, PlantillaEncuesta plantillaEncuesta, Integer nuOrden,
			String dePregunta, String coTipoPregunta, String estado, Date feCreaRegistro, Integer idCreaRegistro,
			Date feModRegistro, Integer idModRegistro, Boolean inEsRptaCorta) {
		this.idPlantillaEncuestaDetalle = id;
		this.plantillaEncuesta = plantillaEncuesta;
		this.nuOrden = nuOrden;
		this.dePregunta = dePregunta;
		this.coTipoPregunta = coTipoPregunta;
		this.estado = estado;
		this.feCreaRegistro = feCreaRegistro;
		this.idCreaRegistro = idCreaRegistro;
		this.feModRegistro = feModRegistro;
		this.idModRegistro = idModRegistro;
		this.inEsRptaCorta = inEsRptaCorta;
	}

	public PlantillaEncuestaPregunta(PlantillaEncuestaPregunta plantillaEncuestaPregunta) {
		this.idPlantillaEncuestaDetalle = plantillaEncuestaPregunta.getIdPlantillaEncuestaDetalle();
		this.nuOrden = plantillaEncuestaPregunta.getNuOrden();
		this.dePregunta = plantillaEncuestaPregunta.getDePregunta();
		this.coTipoPregunta = plantillaEncuestaPregunta.getCoTipoPregunta();
		this.estado = plantillaEncuestaPregunta.getEstado();
		this.feCreaRegistro = plantillaEncuestaPregunta.getFeCreaRegistro();
		this.idCreaRegistro = plantillaEncuestaPregunta.getIdCreaRegistro();
		this.feModRegistro = plantillaEncuestaPregunta.getFeModRegistro();
		this.idModRegistro = plantillaEncuestaPregunta.getIdModRegistro();
		this.inEsRptaCorta = plantillaEncuestaPregunta.getInEsRptaCorta();
	}

	@Id
	@Column(name = "id_plantilla_encuesta_detalle")
    @SequenceGenerator(name="ectd_plantilla_encuesta_id_plantilla_encuesta_detalle_seq", sequenceName="ectd_plantilla_encuesta_id_plantilla_encuesta_detalle_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ectd_plantilla_encuesta_id_plantilla_encuesta_detalle_seq")
	public Integer getIdPlantillaEncuestaDetalle() {
		return idPlantillaEncuestaDetalle;
	}

	public void setIdPlantillaEncuestaDetalle(Integer id) {
		this.idPlantillaEncuestaDetalle = id;
	}

	@OneToMany(mappedBy = "plantillaEncuestaPregunta")
	public List<PlantillaEncuestaRespuesta> getPlantillaEncuestaRespuestas() {
	    if (plantillaEncuestaRespuestas == null) {
	        plantillaEncuestaRespuestas = new ArrayList<>();
	    }
		return plantillaEncuestaRespuestas;
	}

	public void setPlantillaEncuestaRespuestas(List<PlantillaEncuestaRespuesta> plantillaEncuestaRespuestas) {
		this.plantillaEncuestaRespuestas = plantillaEncuestaRespuestas;
	}

	@ManyToOne
	@JoinColumn(name = "id_plantilla_encuesta")
	public PlantillaEncuesta getPlantillaEncuesta() {
		return plantillaEncuesta;
	}

	public void setPlantillaEncuesta(PlantillaEncuesta plantillaEncuesta) {
		this.plantillaEncuesta = plantillaEncuesta;
	}

	@Column(name = "nu_orden")
	public Integer getNuOrden() {
		return nuOrden;
	}

	public void setNuOrden(Integer nuOrden) {
		this.nuOrden = nuOrden;
	}

	@Column(name = "de_pregunta")
	public String getDePregunta() {
		return dePregunta;
	}

	public void setDePregunta(String dePregunta) {
		this.dePregunta = dePregunta;
	}

	@Column(name = "co_tipo_pregunta")
	public String getCoTipoPregunta() {
		return coTipoPregunta;
	}

	public void setCoTipoPregunta(String coTipoPregunta) {
		this.coTipoPregunta = coTipoPregunta;
	}

//    @Column(name = "estado")
    @Column(name = "es_plantilla_encuesta_detalle")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "fe_crea_registro")
	public Date getFeCreaRegistro() {
		return feCreaRegistro;
	}

	public void setFeCreaRegistro(Date feCreaRegistro) {
		this.feCreaRegistro = feCreaRegistro;
	}

	@Column(name = "id_crea_registro")
	public Integer getIdCreaRegistro() {
		return idCreaRegistro;
	}

	public void setIdCreaRegistro(Integer idCreaRegistro) {
		this.idCreaRegistro = idCreaRegistro;
	}

	@Column(name = "fe_mod_registro")
	public Date getFeModRegistro() {
		return feModRegistro;
	}

	public void setFeModRegistro(Date feModRegistro) {
		this.feModRegistro = feModRegistro;
	}

	@Column(name = "id_mod_registro")
	public Integer getIdModRegistro() {
		return idModRegistro;
	}

	public void setIdModRegistro(Integer idModRegistro) {
		this.idModRegistro = idModRegistro;
	}

	@Column(name = "in_es_rpta_corta")
	public Boolean getInEsRptaCorta() {
		return inEsRptaCorta;
	}

	public void setInEsRptaCorta(Boolean inEsRptaCorta) {
		this.inEsRptaCorta = inEsRptaCorta;
	}
}
