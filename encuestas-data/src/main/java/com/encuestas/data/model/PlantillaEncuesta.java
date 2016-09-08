package com.encuestas.data.model;

import java.util.List;

import javax.persistence.*;

import com.encuestas.data.bean.PlantillaEncuestaBean;

/**
 * Created by JaxKodex on 29/11/2015.
 */
@Entity
@Table(name = "ectc_plantilla_encuesta")
public class PlantillaEncuesta {
  private Integer idPlantillaEncuesta;
  // private Empresa empresa;
  private String deEncuestaLargo;
  private String deEncuestaCorto;
  private String coTipoEncuesta;
  private Local local;
  private String esPlantillaEncuesta;
  private Usuario usuario;
  private List<PlantillaEncuestaPregunta> plantillaEncuestaPreguntas;

  public PlantillaEncuesta() {}

  public PlantillaEncuesta(PlantillaEncuestaBean plantillaEncuestaBean) {
    this.idPlantillaEncuesta = plantillaEncuestaBean.getIdPlantillaEncuesta();
    this.deEncuestaLargo = plantillaEncuestaBean.getDeEncuestaLargo();
    this.deEncuestaCorto = plantillaEncuestaBean.getDeEncuestaCorto();
    this.coTipoEncuesta = plantillaEncuestaBean.getCoTipoEncuesta();
    this.esPlantillaEncuesta = plantillaEncuestaBean.getEsPlantillaEncuesta();
    if (plantillaEncuestaBean.getLocal() != null) {
      this.local = new Local(plantillaEncuestaBean.getLocal());
    }
  }

  @Id
  @Column(name = "id_plantilla_encuesta")
  @SequenceGenerator(name = "ectc_plantilla_encuesta_id_plantilla_encuesta_seq",
      sequenceName = "ectc_plantilla_encuesta_id_plantilla_encuesta_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "ectc_plantilla_encuesta_id_plantilla_encuesta_seq")
  public Integer getIdPlantillaEncuesta() {
    return idPlantillaEncuesta;
  }

  @OneToMany(mappedBy = "plantillaEncuesta")
  public List<PlantillaEncuestaPregunta> getPlantillaEncuestaPreguntas() {
    return plantillaEncuestaPreguntas;
  }

  public void setPlantillaEncuestaPreguntas(
      List<PlantillaEncuestaPregunta> plantillaEncuestaPreguntas) {
    this.plantillaEncuestaPreguntas = plantillaEncuestaPreguntas;
  }

  public void setIdPlantillaEncuesta(Integer idPlantillaEncuesta) {
    this.idPlantillaEncuesta = idPlantillaEncuesta;
  }

  // @ManyToOne
  // @JoinColumn(name = "id_empresa")
  // public Empresa getEmpresa() {
  // return empresa;
  // }
  //
  // public void setEmpresa(Empresa empresa) {
  // this.empresa = empresa;
  // }


  @Column(name = "de_encuesta_largo")
  public String getDeEncuestaLargo() {
    return deEncuestaLargo;
  }

  public void setDeEncuestaLargo(String deEncuestaLargo) {
    this.deEncuestaLargo = deEncuestaLargo;
  }

  @Column(name = "de_encuesta_corto")
  public String getDeEncuestaCorto() {
    return deEncuestaCorto;
  }

  public void setDeEncuestaCorto(String deEncuestaCorto) {
    this.deEncuestaCorto = deEncuestaCorto;
  }

  @Column(name = "co_tipo_encuesta")
  public String getCoTipoEncuesta() {
    return coTipoEncuesta;
  }

  public void setCoTipoEncuesta(String coTipoEncuesta) {
    this.coTipoEncuesta = coTipoEncuesta;
  }

  @ManyToOne
  @JoinColumn(name= "id_local")
  public Local getLocal() {
    return local;
  }

  public void setLocal(Local local) {
    this.local = local;
  }

  @Column(name = "es_plantilla_encuesta")
  public String getEsPlantillaEncuesta() {
    return esPlantillaEncuesta;
  }

  public void setEsPlantillaEncuesta(String esPlantillaEncuesta) {
    this.esPlantillaEncuesta = esPlantillaEncuesta;
  }
  
   @ManyToOne
	@JoinColumn(name = "id_usuario_registro")
        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }
}
