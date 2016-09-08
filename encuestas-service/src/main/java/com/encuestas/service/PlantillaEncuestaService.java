/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service;

import com.encuestas.data.bean.PlantillaEncuestaBean;
import com.encuestas.service.exception.DataValidationErrorException;

import java.util.List;

public interface PlantillaEncuestaService {
  
  public List<PlantillaEncuestaBean> listAll();
  
  public List<PlantillaEncuestaBean> listPreguntaAndRespuesta(Integer idLocal);

    public PlantillaEncuestaBean load(Integer idPlantillaEncuesta);
    
    public PlantillaEncuestaBean create (PlantillaEncuestaBean plantillaEncuestaBean, String username) throws DataValidationErrorException;
    
    public PlantillaEncuestaBean update (PlantillaEncuestaBean plantillaEncuestaBean, String username);
}
