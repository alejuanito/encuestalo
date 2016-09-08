package com.encuestas.data.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JaxKodex on 29/11/2015.
 */
public class PlantillaEncuestaPreguntaBean {
	private Integer idPlantillaEncuestaDetalle;
	private PlantillaEncuestaBean plantillaEncuesta;
	private Integer nuOrden;
	private String dePregunta;
	private String coTipoPregunta;
	private String estado;
	private Date feCreaRegistro;
	private Integer idCreaRegistro;
	private Date feModRegistro;
	private Integer idModRegistro;
	private Boolean inEsRptaCorta;
	private List<PlantillaEncuestaRespuestaBean> plantillaEncuestaRespuestas;

	public Integer getIdPlantillaEncuestaDetalle() {
		return idPlantillaEncuestaDetalle;
	}

	public void setIdPlantillaEncuestaDetalle(Integer idPlantillaEncuestaDetalle) {
		this.idPlantillaEncuestaDetalle = idPlantillaEncuestaDetalle;
	}

	public PlantillaEncuestaBean getPlantillaEncuesta() {
		return plantillaEncuesta;
	}

	public void setPlantillaEncuesta(PlantillaEncuestaBean plantillaEncuesta) {
		this.plantillaEncuesta = plantillaEncuesta;
	}

	public Integer getNuOrden() {
		return nuOrden;
	}

	public void setNuOrden(Integer nuOrden) {
		this.nuOrden = nuOrden;
	}

	public String getDePregunta() {
		return dePregunta;
	}

	public void setDePregunta(String dePregunta) {
		this.dePregunta = dePregunta;
	}

	public String getCoTipoPregunta() {
		return coTipoPregunta;
	}

	public void setCoTipoPregunta(String coTipoPregunta) {
		this.coTipoPregunta = coTipoPregunta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFeCreaRegistro() {
		return feCreaRegistro;
	}

	public void setFeCreaRegistro(Date feCreaRegistro) {
		this.feCreaRegistro = feCreaRegistro;
	}

	public Integer getIdCreaRegistro() {
		return idCreaRegistro;
	}

	public void setIdCreaRegistro(Integer idCreaRegistro) {
		this.idCreaRegistro = idCreaRegistro;
	}

	public Date getFeModRegistro() {
		return feModRegistro;
	}

	public void setFeModRegistro(Date feModRegistro) {
		this.feModRegistro = feModRegistro;
	}

	public Integer getIdModRegistro() {
		return idModRegistro;
	}

	public void setIdModRegistro(Integer idModRegistro) {
		this.idModRegistro = idModRegistro;
	}

	public Boolean getInEsRptaCorta() {
		return inEsRptaCorta;
	}

	public void setInEsRptaCorta(Boolean inEsRptaCorta) {
		this.inEsRptaCorta = inEsRptaCorta;
	}

    public List<PlantillaEncuestaRespuestaBean> getPlantillaEncuestaRespuestas() {
        if (plantillaEncuestaRespuestas == null) {
            plantillaEncuestaRespuestas = new ArrayList<>();
        }
        return plantillaEncuestaRespuestas;
    }

    public void setPlantillaEncuestaRespuestas(List<PlantillaEncuestaRespuestaBean> plantillaEncuestaRespuestas) {
        this.plantillaEncuestaRespuestas = plantillaEncuestaRespuestas;
    }
	
}
