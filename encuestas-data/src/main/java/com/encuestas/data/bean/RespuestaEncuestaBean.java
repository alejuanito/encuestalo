package com.encuestas.data.bean;



public class RespuestaEncuestaBean {
	private Integer idEncuestaRespuesta;
        private EncuestaBean encuesta;
        private Integer idRespuesta;
        //private PlantillaEncuestaBean plantillaEncuesta;
        private PlantillaEncuestaPreguntaBean plantillaEncuestaPregunta;
        private String deRespuesta;
        private String dePregunta;
        private String deRespuestaCorta;
        
        public Integer getIdEncuestaRespuesta() {
                return idEncuestaRespuesta;
        }
        public void setIdEncuestaRespuesta(Integer idEncuestaRespuesta) {
                this.idEncuestaRespuesta = idEncuestaRespuesta;
        }
        public EncuestaBean getEncuesta() {
                return encuesta;
        }
        public void setEncuesta(EncuestaBean encuesta) {
                this.encuesta = encuesta;
        }

        public Integer getIdRespuesta() {
            return idRespuesta;
        }

        public void setIdRespuesta(Integer idRespuesta) {
            this.idRespuesta = idRespuesta;
        }
        
        public PlantillaEncuestaPreguntaBean getPlantillaEncuestaPregunta() {
                return plantillaEncuestaPregunta;
        }
        public void setPlantillaEncuestaPregunta(
                        PlantillaEncuestaPreguntaBean plantillaEncuestaPregunta) {
                this.plantillaEncuestaPregunta = plantillaEncuestaPregunta;
        }
        public String getDeRespuesta() {
                return deRespuesta;
        }
        public void setDeRespuesta(String deRespuesta) {
                this.deRespuesta = deRespuesta;
        }

        public String getDePregunta() {
            return dePregunta;
        }

        public void setDePregunta(String dePregunta) {
            this.dePregunta = dePregunta;
        }

        public String getDeRespuestaCorta() {
            return deRespuestaCorta;
        }

        public void setDeRespuestaCorta(String deRespuestaCorta) {
            this.deRespuestaCorta = deRespuestaCorta;
        }
	
        
		
	    
	    
	    


}
