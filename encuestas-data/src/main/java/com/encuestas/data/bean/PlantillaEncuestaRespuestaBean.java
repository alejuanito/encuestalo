package com.encuestas.data.bean;

import java.util.Date;

import com.encuestas.data.model.PlantillaEncuesta;
import com.encuestas.data.model.PlantillaEncuestaPregunta;

public class PlantillaEncuestaRespuestaBean {
	private Integer idRespuesta;
	private String deRespuesta;
	private PlantillaEncuestaPreguntaBean plantillaEncuestaPregunta;
	private Integer nuOrden;
	private String noImg;
	private String esPlantillaEncuestaRespuesta;
	
	public Integer getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(Integer idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	public String getDeRespuesta() {
		return deRespuesta;
	}
	public void setDeRespuesta(String deRespuesta) {
		this.deRespuesta = deRespuesta;
	}
	public PlantillaEncuestaPreguntaBean getPlantillaEncuestaPregunta() {
		return plantillaEncuestaPregunta;
	}
	public void setPlantillaEncuestaPregunta(
			PlantillaEncuestaPreguntaBean plantillaEncuestaPregunta) {
		this.plantillaEncuestaPregunta = plantillaEncuestaPregunta;
	}
	public Integer getNuOrden() {
		return nuOrden;
	}
	public void setNuOrden(Integer nuOrden) {
		this.nuOrden = nuOrden;
	}
	public String getNoImg() {
		return noImg;
	}
	public void setNoImg(String noImg) {
		this.noImg = noImg;
	}
    public String getEsPlantillaEncuestaRespuesta() {
        return esPlantillaEncuestaRespuesta;
    }
    public void setEsPlantillaEncuestaRespuesta(String esPlantillaEncuestaRespuesta) {
        this.esPlantillaEncuestaRespuesta = esPlantillaEncuestaRespuesta;
    }
}
