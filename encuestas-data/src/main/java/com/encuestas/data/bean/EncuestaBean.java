package com.encuestas.data.bean;

import java.util.Date;



public class EncuestaBean {
	private Integer idEncuesta;	    
        private AtencionBean atencion;
        private Date feEncuesta;
        private ClienteBean cliente;
        private LocalBean local;
        private String nuEncuesta;
        private Integer nuCorrelativo;
        public Integer getIdEncuesta() {
                return idEncuesta;
        }
        public void setIdEncuesta(Integer idEncuesta) {
                this.idEncuesta = idEncuesta;
        }
        public AtencionBean getAtencion() {
                return atencion;
        }
        public void setAtencion(AtencionBean atencion) {
                this.atencion = atencion;
        }

        public Date getFeEncuesta() {
            return feEncuesta;
        }

        public void setFeEncuesta(Date feEncuesta) {
            this.feEncuesta = feEncuesta;
        }

        public ClienteBean getCliente() {
            return cliente;
        }

        public void setCliente(ClienteBean cliente) {
            this.cliente = cliente;
        }

        public LocalBean getLocal() {
            return local;
        }

        public void setLocal(LocalBean local) {
            this.local = local;
        }

    public String getNuEncuesta() {
        return nuEncuesta;
    }

    public void setNuEncuesta(String nuEncuesta) {
        this.nuEncuesta = nuEncuesta;
    }

    public Integer getNuCorrelativo() {
        return nuCorrelativo;
    }

    public void setNuCorrelativo(Integer nuCorrelativo) {
        this.nuCorrelativo = nuCorrelativo;
    }

       
	    
	    


}
