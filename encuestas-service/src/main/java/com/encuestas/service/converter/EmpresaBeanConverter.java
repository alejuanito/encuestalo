/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import com.encuestas.data.bean.EmpresaBean;
import com.encuestas.data.model.Empresa;
import java.util.ArrayList;
import java.util.List;


public class EmpresaBeanConverter implements DataConverter<EmpresaBean, Empresa> {

    @Override
    public List<Empresa> convertList(List<EmpresaBean> dataList) {
        List<Empresa> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (EmpresaBean empresa : dataList) {
            data.add(convert(empresa));
        }
        return data;
    }

    @Override
    public Empresa convert(EmpresaBean empresa) {
        if (empresa == null) {
            return null;
        }
        Empresa empresaBean = new Empresa();
        empresaBean.setIdEmpresa(empresa.getIdEmpresa());
        empresaBean.setNombre(empresa.getNombre());
        empresaBean.setDireccion(empresa.getDireccion());
        return empresaBean;
    }
    
}
