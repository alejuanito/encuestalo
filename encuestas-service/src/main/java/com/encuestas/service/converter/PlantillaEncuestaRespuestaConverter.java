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
public class PlantillaEncuestaRespuestaConverter implements DataConverter<PlantillaEncuestaRespuesta, PlantillaEncuestaRespuestaBean> {

    @Override
    public List<PlantillaEncuestaRespuestaBean> convertList(List<PlantillaEncuestaRespuesta> dataList) {
        List<PlantillaEncuestaRespuestaBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (PlantillaEncuestaRespuesta respuesta : dataList) {
            data.add(convert(respuesta));
        }
        return data;
    }

    @Override
    public PlantillaEncuestaRespuestaBean convert(PlantillaEncuestaRespuesta respuesta) {
        if (respuesta == null) {
            return null;
        }
        PlantillaEncuestaRespuestaBean respuestaBean = new PlantillaEncuestaRespuestaBean();
        
        respuestaBean.setDeRespuesta(respuesta.getDeRespuesta());
        respuestaBean.setIdRespuesta(respuesta.getIdRespuesta());
        respuestaBean.setNuOrden(respuesta.getNuOrden());
        respuestaBean.setNoImg(respuesta.getNoImg());
        respuestaBean.setEsPlantillaEncuestaRespuesta(respuesta.getEsPlantillaEncuestaRespuesta());
//        respuestaBean.setPlantillaEncuestaPregunta(new PlantillaEncuestaPreguntaConverter().convert(respuesta.getPlantillaEncuestaPregunta()));
           
        return respuestaBean;
    }
    
    
    
    
}
