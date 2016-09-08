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
import com.encuestas.data.model.Area;
import com.encuestas.data.model.Atencion;
import com.encuestas.data.model.Empresa;
import com.encuestas.data.model.PlantillaEncuesta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e00309
 */
public class PlantillaEncuestaConverter implements DataConverter<PlantillaEncuesta, PlantillaEncuestaBean> {

    @Override
    public List<PlantillaEncuestaBean> convertList(List<PlantillaEncuesta> dataList) {
        List<PlantillaEncuestaBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (PlantillaEncuesta plantilla : dataList) {
            data.add(convert(plantilla));
        }
        return data;
    }

    @Override
    public PlantillaEncuestaBean convert(PlantillaEncuesta plantilla) {
        if (plantilla == null) {
            return null;
        }
        PlantillaEncuestaBean plantillaBean = new PlantillaEncuestaBean();
        plantillaBean.setCoTipoEncuesta(plantilla.getCoTipoEncuesta());
        // TODO cambiar por local
//        plantillaBean.setEmpresa(new EmpresaConverter().convert(plantilla.getEmpresa()));
        plantillaBean.setLocal(new LocalConverter().convert(plantilla.getLocal()));
        plantillaBean.setIdPlantillaEncuesta(plantilla.getIdPlantillaEncuesta());
        plantillaBean.setDeEncuestaCorto(plantilla.getDeEncuestaCorto());
        plantillaBean.setDeEncuestaLargo(plantilla.getDeEncuestaLargo());
        plantillaBean.setEsPlantillaEncuesta(plantilla.getEsPlantillaEncuesta());
    
        return plantillaBean;
    }
    
    
    
    
}
