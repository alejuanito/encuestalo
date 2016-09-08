/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import com.encuestas.data.bean.AreaBean;
import com.encuestas.data.bean.EmpresaBean;
import com.encuestas.data.bean.LocalBean;
import com.encuestas.data.model.Area;
import com.encuestas.data.model.Empresa;
import com.encuestas.data.model.Local;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e00309
 */
public class LocalBeanConverter implements DataConverter<LocalBean,Local> {

    @Override
    public List<Local> convertList(List<LocalBean> dataList) {
        List<Local> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }	
        for (LocalBean local : dataList) {
            data.add(convert(local));
        }
        return data;
    }

    @Override
    public Local convert(LocalBean local) {
        if (local == null) {
            return null;
        }
        Local localBean = new Local();
        localBean.setIdLocal(local.getIdLocal());
        localBean.setNoLocal(local.getNoLocal());
        localBean.setEmpresa(new EmpresaBeanConverter().convert(local.getEmpresa()));
        localBean.setNuLocal(local.getNuLocal());
        return localBean;
    }
    
}
