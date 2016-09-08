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
import com.encuestas.data.model.Area;
import com.encuestas.data.model.Atencion;
import com.encuestas.data.model.Empresa;
import com.encuestas.data.model.PlantillaEncuesta;
import com.encuestas.data.model.PlantillaEncuestaPregunta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e00309
 */
public class PlantillaEncuestaPreguntaBeanConverter implements DataConverter<PlantillaEncuestaPreguntaBean, PlantillaEncuestaPregunta> {

    @Override
    public List<PlantillaEncuestaPregunta> convertList(List<PlantillaEncuestaPreguntaBean> dataList) {
        List<PlantillaEncuestaPregunta> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (PlantillaEncuestaPreguntaBean pregunta : dataList) {
            data.add(convert(pregunta));
        }
        return data;
    }

    @Override
    public PlantillaEncuestaPregunta convert(PlantillaEncuestaPreguntaBean preguntaBean) {
        if (preguntaBean == null) {
            return null;
        }
        PlantillaEncuestaPregunta pregunta = new PlantillaEncuestaPregunta();
        pregunta.setCoTipoPregunta(preguntaBean.getCoTipoPregunta());
        pregunta.setDePregunta(preguntaBean.getDePregunta());
        pregunta.setEstado(preguntaBean.getEstado());
        pregunta.setFeCreaRegistro(preguntaBean.getFeCreaRegistro());
        pregunta.setFeModRegistro(preguntaBean.getFeModRegistro());
        pregunta.setIdCreaRegistro(preguntaBean.getIdCreaRegistro());
        pregunta.setIdModRegistro(preguntaBean.getIdModRegistro());
        pregunta.setIdPlantillaEncuestaDetalle(preguntaBean.getIdPlantillaEncuestaDetalle());
        pregunta.setNuOrden(preguntaBean.getNuOrden());
        pregunta.setInEsRptaCorta(preguntaBean.getInEsRptaCorta());
        pregunta.setPlantillaEncuesta(new PlantillaEncuestaBeanConverter().convert(preguntaBean.getPlantillaEncuesta()));
        
        return pregunta;
    }
    
    
    
    
}
