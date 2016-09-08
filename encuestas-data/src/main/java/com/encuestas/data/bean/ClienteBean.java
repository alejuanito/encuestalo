package com.encuestas.data.bean;


public class ClienteBean {
    private Integer idCliente;
    private PersonaBean persona;
    private EmpresaBean empresa;
    private Boolean inPromocion;
    private Integer idEncuesta;

    private LocalBean ultimoLocalVisitado;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public PersonaBean getPersona() {
        return persona;
    }

    public void setPersona(PersonaBean persona) {
        this.persona = persona;
    }

    public EmpresaBean getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaBean empresa) {
        this.empresa = empresa;
    }

    public Boolean getInPromocion() {
        return inPromocion;
    }

    public void setInPromocion(Boolean inPromocion) {
        this.inPromocion = inPromocion;
    }

    public Integer getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public LocalBean getUltimoLocalVisitado() {
        return ultimoLocalVisitado;
    }

    public void setUltimoLocalVisitado(LocalBean ultimoLocalVisitado) {
        this.ultimoLocalVisitado = ultimoLocalVisitado;
    }
}
