/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import java.util.Collection;
import java.util.List;

import com.encuestas.data.bean.PlantillaEncuestaBean;
import com.encuestas.data.model.Empresa;
import com.encuestas.data.model.PlantillaEncuesta;
import com.encuestas.data.model.PlantillaEncuestaPregunta;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author e00309
 */
public interface PlantillaEncuestaPreguntaRepository extends JpaRepository<PlantillaEncuestaPregunta, Integer>{

//  public List<PlantillaEncuestaPregunta> findByPlantillaEncuestaEmpresaIdEmpresaAndPlantillaEncuestaCoTipoEncuestaAndEstadoOrderByCoTipoPreguntaDescNuOrdenAsc(Integer idEmpresa, String coTipoEncuesta, String estado);
  public List<PlantillaEncuestaPregunta> findByPlantillaEncuestaLocalIdLocalAndPlantillaEncuestaCoTipoEncuestaAndEstadoOrderByCoTipoPreguntaDescNuOrdenAsc(Integer idLocal, String coTipoEncuesta, String estado);
	
  public List<PlantillaEncuestaPregunta> findByPlantillaEncuestaIdPlantillaEncuestaAndPlantillaEncuestaCoTipoEncuesta (Integer idPlantillaEncuesta, String coTipoEncuesta);
	
  public List<PlantillaEncuestaPregunta> findByIdPlantillaEncuestaDetalleIn (Collection<Integer> idPlantillaEncuestaDetalle);

  List<PlantillaEncuestaPregunta> findByPlantillaEncuestaIdPlantillaEncuestaAndEstadoOrderByCoTipoPreguntaDescNuOrdenAsc (Integer idPlantillaEncuesta, String estado);

  
   @Query("select pregunta "
           + " from PlantillaEncuestaPregunta pregunta "
           + " inner join pregunta.plantillaEncuesta plantilla "
           + " inner join plantilla.local local "            
            + "where ((?1) = 0 or local.idLocal = cast((?1) as integer)) and pregunta.estado = ?2 ")
   List<PlantillaEncuestaPregunta> listPreguntasReporte (Integer idLocal, String estado);
  
}
