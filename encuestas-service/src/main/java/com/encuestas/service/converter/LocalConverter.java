/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.bean.LocalBean;
import com.encuestas.data.model.Local;

/**
 *
 * @author e00309
 */
public class LocalConverter implements DataConverter<Local,LocalBean> {

    @Override
    public List<LocalBean> convertList(List<Local> dataList) {
        List<LocalBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }	
        for (Local local : dataList) {
            data.add(convert(local));
        }
        return data;
    }

    @Override
    public LocalBean convert(Local local) {
        if (local == null) {
            return null;
        }
        LocalBean localBean = new LocalBean();
        localBean.setIdLocal(local.getIdLocal());
        localBean.setNoLocal(local.getNoLocal());
        localBean.setCoLocal(local.getCoLocal());
        localBean.setEmpresa(new EmpresaConverter().convert(local.getEmpresa()));
        localBean.setNuLocal(local.getNuLocal());
        return localBean;
    }
    
}
