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
public class AreaConverter implements DataConverter<Area, AreaBean> {

    @Override
    public List<AreaBean> convertList(List<Area> dataList) {
        List<AreaBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (Area area : dataList) {
            data.add(convert(area));
        }
        return data;
    }

    @Override
    public AreaBean convert(Area area) {
        if (area == null) {
            return null;
        }
        AreaBean areaBean = new AreaBean();
        areaBean.setIdArea(area.getIdArea());
        areaBean.setLocal(new LocalConverter().convert(area.getLocal()));    
        areaBean.setDeArea(area.getDeArea());
        return areaBean;
    }
    
}
