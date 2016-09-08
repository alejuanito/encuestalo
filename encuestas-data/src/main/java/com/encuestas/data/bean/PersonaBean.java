package com.encuestas.data.bean;


import java.util.Date;


public class PersonaBean {
    private Integer idPersona;
    private String amPersona;
    private String noPersona;
    private String apPersona;
    private Date feNacimiento;
    private String feNacimientoString;
    private String nuTelefonoFijo;
    private String noTelefonoCelular;
    private String deEmail;
    private String esPersona;
    private String nuDocumento;
    private String coSexo;
    private TipoDocumentoBean tipoDocumento;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getAmPersona() {
        return amPersona;
    }

    public void setAmPersona(String amPersona) {
        this.amPersona = amPersona;
    }

    public String getNoPersona() {
        return noPersona;
    }

    public void setNoPersona(String noPersona) {
        this.noPersona = noPersona;
    }

    public String getApPersona() {
        return apPersona;
    }

    public void setApPersona(String apPersona) {
        this.apPersona = apPersona;
    }

    public Date getFeNacimiento() {
        return feNacimiento;
    }

    public void setFeNacimiento(Date feNacimiento) {
        this.feNacimiento = feNacimiento;
    }

    public String getNuTelefonoFijo() {
        return nuTelefonoFijo;
    }

    public void setNuTelefonoFijo(String nuTelefonoFijo) {
        this.nuTelefonoFijo = nuTelefonoFijo;
    }

    public String getNoTelefonoCelular() {
        return noTelefonoCelular;
    }

    public void setNoTelefonoCelular(String noTelefonoCelular) {
        this.noTelefonoCelular = noTelefonoCelular;
    }

    public String getDeEmail() {
        return deEmail;
    }

    public void setDeEmail(String deEmail) {
        this.deEmail = deEmail;
    }

    public String getEsPersona() {
        return esPersona;
    }

    public void setEsPersona(String esPersona) {
        this.esPersona = esPersona;
    }

    public String getNuDocumento() {
        return nuDocumento;
    }

    public void setNuDocumento(String nuDocumento) {
        this.nuDocumento = nuDocumento;
    }

    public String getCoSexo() {
        return coSexo;
    }

    public void setCoSexo(String coSexo) {
        this.coSexo = coSexo;
    }

    public TipoDocumentoBean getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoBean tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getEdad () {
        if (feNacimiento == null) {
            return 0;
        }
        Date now = new Date();
        long timeBetween = now.getTime() - feNacimiento.getTime();
        double yearsBetween = timeBetween / 3.156e+10;
        return (int) Math.floor(yearsBetween);
    }

    public String getFeNacimientoString() {
        return feNacimientoString;
    }

    public void setFeNacimientoString(String feNacimientoString) {
        this.feNacimientoString = feNacimientoString;
    }

    
}
