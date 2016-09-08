/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import java.util.List;

import com.encuestas.data.model.Area;
import com.encuestas.data.model.Empresa;
import com.encuestas.data.model.PlantillaEncuesta;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PlantillaEncuestaRepository extends JpaRepository<PlantillaEncuesta, Integer>{
    
//	@Query("select pe "
//			+ " from PlantillaEncuesta  pe "
//			+ " left join pe.plantillaEncuestaPreguntas pr "
//			+ " left join pr.plantillaEncuestaRespuestas re "			
//			+ " where pe.empresa.idEmpresa = ?1 and pe.coTipoEncuesta = ?2 ") 
//	List<PlantillaEncuesta> findEncuestaPreguntaRespuestaByEmpresaAndTipoEncuesta
//							(Integer idEmpresa,String coTipoEncuesta);


    @Query("select pe "
            + " from PlantillaEncuesta  pe "
            + " left join pe.plantillaEncuestaPreguntas pr "
            + " left join pr.plantillaEncuestaRespuestas re "
            + " where pe.local.idLocal = ?1 and pe.coTipoEncuesta = ?2 ")
    List<PlantillaEncuesta> findEncuestaPreguntaRespuestaByLocalAndTipoEncuesta
            (Integer idLocal, String coTipoEncuesta);

    @Query("select pe from PlantillaEncuesta  pe " +
            "left join pe.plantillaEncuestaPreguntas pr " +
            "left join pr.plantillaEncuestaRespuestas re " +
            "where pe.local.idLocal = ?1 " +
            "and pe.coTipoEncuesta = ?2 " +
            "and pe.esPlantillaEncuesta = ?3")
    List<PlantillaEncuesta> findEncuestaPreguntaRespuestaByLocalAndTipoEncuesta
            (Integer idLocal, String coTipoEncuesta, String esPlantillaEncuesta);
}
