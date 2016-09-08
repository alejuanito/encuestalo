package com.encuestas.data.bean;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RespuestaEncuestaReporteBean {
    private Integer id;
    private PlantillaEncuestaPreguntaBean plantillaEncuestaPregunta;
    private List<Respuesta> respuestas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RespuestaEncuestaReporteBean() {
        respuestas = new ArrayList<>();
    }

    public PlantillaEncuestaPreguntaBean getPlantillaEncuestaPregunta() {
        return plantillaEncuestaPregunta;
    }

    public void setPlantillaEncuestaPregunta(PlantillaEncuestaPreguntaBean plantillaEncuestaPregunta) {
        this.plantillaEncuestaPregunta = plantillaEncuestaPregunta;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public static class Respuesta {
        private PlantillaEncuestaRespuestaBean plantillaEncuestaRespuestaBean;
        private BigInteger cuenta;

        public PlantillaEncuestaRespuestaBean getPlantillaEncuestaRespuestaBean() {
            return plantillaEncuestaRespuestaBean;
        }

        public void setPlantillaEncuestaRespuestaBean(PlantillaEncuestaRespuestaBean plantillaEncuestaRespuestaBean) {
            this.plantillaEncuestaRespuestaBean = plantillaEncuestaRespuestaBean;
        }

        public BigInteger getCuenta() {
            return cuenta;
        }

        public void setCuenta(BigInteger cuenta) {
            this.cuenta = cuenta;
        }
    }
}
