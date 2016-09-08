package com.encuestas.data.model;

import com.encuestas.data.util.UpperCaseType;
import javax.persistence.*;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Type;

@TypeDef(
        name = "upperCase",
        typeClass = UpperCaseType.class,
        parameters = {
            @Parameter(name = "cast", value = "upper")
        }
)

@Entity
@Table(name = "ectd_plantilla_encuesta_respuesta")
public class PlantillaEncuestaRespuesta {
	private Integer idRespuesta;
	private String deRespuesta;
	private PlantillaEncuestaPregunta plantillaEncuestaPregunta;
	private Integer nuOrden;
	private String noImg;
	private String esPlantillaEncuestaRespuesta;
	
	
	@Id
	@Column(name = "id_respuesta")
	@SequenceGenerator(name="ectd_plantilla_encuesta_respuesta_id_respuesta_seq", sequenceName="ectd_plantilla_encuesta_respuesta_id_respuesta_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ectd_plantilla_encuesta_respuesta_id_respuesta_seq")
	public Integer getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(Integer idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
        
        @Type(type="upperCase")
	@Column(name = "de_respuesta")
	public String getDeRespuesta() {
		return deRespuesta;
	}
        
        @Type(type="upperCase")
	public void setDeRespuesta(String deRespuesta) {
		this.deRespuesta = deRespuesta;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_plantilla_encuesta_detalle")
	public PlantillaEncuestaPregunta getPlantillaEncuestaPregunta() {
		return plantillaEncuestaPregunta;
	}
	public void setPlantillaEncuestaPregunta(
			PlantillaEncuestaPregunta plantillaEncuestaPregunta) {
		this.plantillaEncuestaPregunta = plantillaEncuestaPregunta;
	}
	
	@Column(name = "nu_orden")        
	public Integer getNuOrden() {
		return nuOrden;
	}
	public void setNuOrden(Integer nuOrden) {
		this.nuOrden = nuOrden;
	}
	
	@Column(name = "no_img")
	public String getNoImg() {
		return noImg;
	}
	
	public void setNoImg(String noImg) {
		this.noImg = noImg;
	}
	
	@Column(name = "es_plantilla_encuesta_respuesta")
    public String getEsPlantillaEncuestaRespuesta() {
        return esPlantillaEncuestaRespuesta;
    }
    
    public void setEsPlantillaEncuestaRespuesta(String esPlantillaEncuestaRespuesta) {
        this.esPlantillaEncuestaRespuesta = esPlantillaEncuestaRespuesta;
    }	
}
