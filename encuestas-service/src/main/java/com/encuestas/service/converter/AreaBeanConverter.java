/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import com.encuestas.data.bean.AreaBean;
import com.encuestas.data.bean.EmpresaBean;
import com.encuestas.data.model.Area;
import com.encuestas.data.model.Empresa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e00309
 */
public class AreaBeanConverter implements DataConverter<AreaBean, Area> {

    @Override
    public List<Area> convertList(List<AreaBean> dataList) {
        List<Area> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (AreaBean area : dataList) {
            data.add(convert(area));
        }
        return data;
    }

    @Override
    public Area convert(AreaBean area) {
        if (area == null) {
            return null;
        }
        Area areaBean = new Area();
        areaBean.setIdArea(area.getIdArea());
        areaBean.setLocal(new LocalBeanConverter().convert(area.getLocal()));    
        areaBean.setDeArea(area.getDeArea());
        return areaBean;
    }
    
}
