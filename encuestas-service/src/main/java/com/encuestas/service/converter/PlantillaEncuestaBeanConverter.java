/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import com.encuestas.data.bean.PlantillaEncuestaBean;
import com.encuestas.data.model.PlantillaEncuesta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e00309
 */
public class PlantillaEncuestaBeanConverter implements DataConverter<PlantillaEncuestaBean, PlantillaEncuesta> {

    @Override
    public List<PlantillaEncuesta> convertList(List<PlantillaEncuestaBean> dataList) {
        List<PlantillaEncuesta> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (PlantillaEncuestaBean plantilla : dataList) {
            data.add(convert(plantilla));
        }
        return data;
    }

    @Override
    public PlantillaEncuesta convert(PlantillaEncuestaBean plantilla) {
        if (plantilla == null) {
            return null;
        }
        PlantillaEncuesta plantillaBean = new PlantillaEncuesta();
        plantillaBean.setIdPlantillaEncuesta(plantilla.getIdPlantillaEncuesta());
        plantillaBean.setCoTipoEncuesta(plantilla.getCoTipoEncuesta());
        // TODO Cambiar por local
//        plantillaBean.setEmpresa(new EmpresaBeanConverter().convert(plantilla.getEmpresa()));
        plantillaBean.setIdPlantillaEncuesta(plantilla.getIdPlantillaEncuesta());
        plantillaBean.setDeEncuestaCorto(plantilla.getDeEncuestaCorto());
        plantillaBean.setDeEncuestaLargo(plantilla.getDeEncuestaLargo());
        plantillaBean.setEsPlantillaEncuesta(plantilla.getEsPlantillaEncuesta());
        
        return plantillaBean;
    }
    
    
    
    
}
