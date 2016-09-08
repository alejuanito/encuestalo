package com.encuestas.data.bean;

import java.sql.Timestamp;

import java.util.Date;


public class PromocionEnviadaBean {
    private ClienteBean cliente;
    private Integer idPromocionEnviada;
    private PromocionBean promocion;
    private Date feEnvio;

    private EmpresaBean empresa;
    private UsuarioBean usuario;

    public ClienteBean getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBean cliente) {
        this.cliente = cliente;
    }

    public Integer getIdPromocionEnviada() {
        return idPromocionEnviada;
    }

    public void setIdPromocionEnviada(Integer idPromocionEnviada) {
        this.idPromocionEnviada = idPromocionEnviada;
    }

    public PromocionBean getPromocion() {
        return promocion;
    }

    public void setPromocion(PromocionBean promocion) {
        this.promocion = promocion;
    }

    public Date getFeEnvio() {
        return feEnvio;
    }


    public void setFeEnvio(Date feEnvio) {

        this.feEnvio = feEnvio;
    }


    public EmpresaBean getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaBean empresa) {
        this.empresa = empresa;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }
}
