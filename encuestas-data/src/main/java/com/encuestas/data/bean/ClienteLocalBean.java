	package com.encuestas.data.bean;

import java.util.Date;


public class ClienteLocalBean {
    private Integer idClienteLocal;
    private LocalBean local;
    private ClienteBean cliente;
    private Date feCreaRegistro;

    public Integer getIdClienteLocal() {
        return idClienteLocal;
    }

    public void setIdClienteLocal(Integer idClienteLocal) {
        this.idClienteLocal = idClienteLocal;
    }

    public LocalBean getLocal() {
        return local;
    }

    public void setLocal(LocalBean local) {
        this.local = local;
    }

    public ClienteBean getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBean cliente) {
        this.cliente = cliente;
    }

    public Date getFeCreaRegistro() {
        return feCreaRegistro;
    }

    public void setFeCreaRegistro(Date feCreaRegistro) {
        this.feCreaRegistro = feCreaRegistro;
    }
	
	    


}
