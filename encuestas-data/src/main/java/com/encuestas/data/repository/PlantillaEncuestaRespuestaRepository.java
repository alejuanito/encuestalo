/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.data.repository;

import java.util.Collection;
import java.util.List;

import com.encuestas.data.model.PlantillaEncuestaRespuesta;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author e00309
 */
public interface PlantillaEncuestaRespuestaRepository extends JpaRepository<PlantillaEncuestaRespuesta, Integer>{
	
	List<PlantillaEncuestaRespuesta> findByPlantillaEncuestaPreguntaIdPlantillaEncuestaDetalleOrderByNuOrdenAsc
	   (Integer idPlantillaEncuestaDetalle);
    
	public List<PlantillaEncuestaRespuesta> findByIdRespuestaIn (Collection<Integer> idRespuestaList);
        
        

}
