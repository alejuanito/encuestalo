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

/**
 *
 * @author e00309
 */
public class EmpresaConverter implements DataConverter<Empresa, EmpresaBean> {

    @Override
    public List<EmpresaBean> convertList(List<Empresa> dataList) {
        List<EmpresaBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (Empresa empresa : dataList) {
            data.add(convert(empresa));
        }
        return data;
    }

    @Override
    public EmpresaBean convert(Empresa empresa) {
        if (empresa == null) {
            return null;
        }
        EmpresaBean empresaBean = new EmpresaBean();
        empresaBean.setIdEmpresa(empresa.getIdEmpresa());
        empresaBean.setNombre(empresa.getNombre());
        empresaBean.setDireccion(empresa.getDireccion());
        return empresaBean;
    }
    
}
