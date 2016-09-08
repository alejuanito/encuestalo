/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service;

import com.encuestas.data.bean.PlantillaEncuestaPreguntaBean;

import java.util.List;

public interface PlantillaEncuestaPreguntaService {
    
    public List<PlantillaEncuestaPreguntaBean> listPreguntaAtencion(String username);
    
    public List<PlantillaEncuestaPreguntaBean> listPreguntaAtencionByIdPlantillaEncuesta (Integer idPlantillaEncuesta);
    
    public PlantillaEncuestaPreguntaBean load (Integer idPlantillaEncuestaPregunta);
    
    public PlantillaEncuestaPreguntaBean crear (PlantillaEncuestaPreguntaBean plantillaEncuestaPreguntaBean);
    
    public PlantillaEncuestaPreguntaBean actualizar (PlantillaEncuestaPreguntaBean plantillaEncuestaPreguntaBean);
    
    public void eliminar (Integer idPlantillaEncuestaPregunta);
    public List<PlantillaEncuestaPreguntaBean> listPreguntaParaReporte(Integer idLocal);
}
