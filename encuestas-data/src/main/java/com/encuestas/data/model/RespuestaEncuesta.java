package com.encuestas.data.model;

import java.util.List;

import javax.persistence.*;

import com.encuestas.data.bean.PlantillaEncuestaBean;

@Entity
@Table(name = "ectd_encuesta_respuesta")
public class RespuestaEncuesta {
    private Integer idEncuestaRespuesta;
    private Encuesta encuesta;
    private Integer idRespuesta;
    private PlantillaEncuestaPregunta plantillaEncuestaPregunta;
    private String deRespuesta;
    private String dePregunta;
    private String deRespuestaCorta;
  
    
    public RespuestaEncuesta () {
    }
    

    @Id
    @SequenceGenerator(name="ectd_encuesta_respuesta_id_encuesta_respuesta_seq", sequenceName="ectd_encuesta_respuesta_id_encuesta_respuesta_seq", allocationSize=1)	
    @Column(name = "id_encuesta_respuesta")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ectd_encuesta_respuesta_id_encuesta_respuesta_seq")    
    public Integer getIdEncuestaRespuesta() {
		return idEncuestaRespuesta;
	}



	public void setIdEncuestaRespuesta(Integer idEncuestaRespuesta) {
		this.idEncuestaRespuesta = idEncuestaRespuesta;
	}


	 @ManyToOne
	 @JoinColumn(name = "id_encuesta")
	public Encuesta getEncuesta() {
		return encuesta;
	}



	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}


	 //@ManyToOne
	 
        @Column(name = "id_respuesta")
        public Integer getIdRespuesta() {
            return idRespuesta;
        }

        public void setIdRespuesta(Integer idRespuesta) {
            this.idRespuesta = idRespuesta;
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

	@Column(name = "de_respuesta")
	public String getDeRespuesta() {
		return deRespuesta;
	}


	public void setDeRespuesta(String deRespuesta) {
		this.deRespuesta = deRespuesta;
	}
        @Column(name = "de_pregunta")
        public String getDePregunta() {
            return dePregunta;
        }

        public void setDePregunta(String dePregunta) {
            this.dePregunta = dePregunta;
        }
        @Column(name = "de_respuesta_corta")
        public String getDeRespuestaCorta() {
            return deRespuestaCorta;
        }

        public void setDeRespuestaCorta(String deRespuestaCorta) {
            this.deRespuestaCorta = deRespuestaCorta;
        }


	




}
