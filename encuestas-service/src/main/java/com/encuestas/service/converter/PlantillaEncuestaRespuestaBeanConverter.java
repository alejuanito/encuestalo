/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import com.encuestas.data.bean.AreaBean;
import com.encuestas.data.bean.AtencionBean;
import com.encuestas.data.bean.EmpresaBean;
import com.encuestas.data.bean.PlantillaEncuestaBean;
import com.encuestas.data.bean.PlantillaEncuestaPreguntaBean;
import com.encuestas.data.bean.PlantillaEncuestaRespuestaBean;
import com.encuestas.data.model.Area;
import com.encuestas.data.model.Atencion;
import com.encuestas.data.model.Empresa;
import com.encuestas.data.model.PlantillaEncuesta;
import com.encuestas.data.model.PlantillaEncuestaPregunta;
import com.encuestas.data.model.PlantillaEncuestaRespuesta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e00309
 */
public class PlantillaEncuestaRespuestaBeanConverter implements DataConverter<PlantillaEncuestaRespuestaBean, PlantillaEncuestaRespuesta> {

    @Override
    public List<PlantillaEncuestaRespuesta> convertList(List<PlantillaEncuestaRespuestaBean> dataList) {
        List<PlantillaEncuestaRespuesta> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (PlantillaEncuestaRespuestaBean respuesta : dataList) {
            data.add(convert(respuesta));
        }
        return data;
    }

    @Override
    public PlantillaEncuestaRespuesta convert(PlantillaEncuestaRespuestaBean respuesta) {
        if (respuesta == null) {
            return null;
        }
        PlantillaEncuestaRespuesta respuestaBean = new PlantillaEncuestaRespuesta();
        
        respuestaBean.setDeRespuesta(respuesta.getDeRespuesta());
        respuestaBean.setIdRespuesta(respuesta.getIdRespuesta());
        respuestaBean.setNuOrden(respuesta.getNuOrden());
        respuestaBean.setNoImg(respuesta.getNoImg());
        respuestaBean.setEsPlantillaEncuestaRespuesta(respuesta.getEsPlantillaEncuestaRespuesta());
        respuestaBean.setPlantillaEncuestaPregunta(new PlantillaEncuestaPreguntaBeanConverter().convert(respuesta.getPlantillaEncuestaPregunta()));
           
        return respuestaBean;
    }
    
    
    
    
}
