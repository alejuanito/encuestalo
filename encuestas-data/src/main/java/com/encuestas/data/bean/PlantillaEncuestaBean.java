package com.encuestas.data.bean;

import java.util.List;

/**
 * Created by JaxKodex on 29/11/2015.
 */
public class PlantillaEncuestaBean {
  private Integer idPlantillaEncuesta;
  // private EmpresaBean empresa;
  private LocalBean local;
  private String deEncuestaLargo;
  private String deEncuestaCorto;
  private String coTipoEncuesta;
  private String esPlantillaEncuesta;
  private List<PlantillaEncuestaPreguntaBean> plantillaEncuestaPreguntas;


  public Integer getIdPlantillaEncuesta() {
    return idPlantillaEncuesta;
  }

  public void setIdPlantillaEncuesta(Integer idPlantillaEncuesta) {
    this.idPlantillaEncuesta = idPlantillaEncuesta;
  }

  public String getDeEncuestaLargo() {
    return deEncuestaLargo;
  }

  public void setDeEncuestaLargo(String deEncuestaLargo) {
    this.deEncuestaLargo = deEncuestaLargo;
  }

  public String getDeEncuestaCorto() {
    return deEncuestaCorto;
  }

  public void setDeEncuestaCorto(String deEncuestaCorto) {
    this.deEncuestaCorto = deEncuestaCorto;
  }

  public String getCoTipoEncuesta() {
    return coTipoEncuesta;
  }

  public void setCoTipoEncuesta(String coTipoEncuesta) {
    this.coTipoEncuesta = coTipoEncuesta;
  }

//  public EmpresaBean getEmpresa() {
//    return empresa;
//  }
//
//  public void setEmpresa(EmpresaBean empresa) {
//    this.empresa = empresa;
//  }

  public List<PlantillaEncuestaPreguntaBean> getPlantillaEncuestaPreguntas() {
    return plantillaEncuestaPreguntas;
  }

  public void setPlantillaEncuestaPreguntas(
      List<PlantillaEncuestaPreguntaBean> plantillaEncuestaPreguntas) {
    this.plantillaEncuestaPreguntas = plantillaEncuestaPreguntas;
  }

  public LocalBean getLocal() {
    return local;
  }

  public void setLocal(LocalBean local) {
    this.local = local;
  }

  public String getEsPlantillaEncuesta() {
    return esPlantillaEncuesta;
  }

  public void setEsPlantillaEncuesta(String esPlantillaEncuesta) {
    this.esPlantillaEncuesta = esPlantillaEncuesta;
  }
}
