/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.bean.AtencionBean;
import com.encuestas.data.model.Atencion;

/**
 *
 * @author e00309
 */
public class AtencionConverter implements DataConverter<Atencion, AtencionBean> {

    @Override
    public List<AtencionBean> convertList(List<Atencion> dataList) {
        List<AtencionBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (Atencion atencion : dataList) {
            data.add(convert(atencion));
        }
        return data;
    }

    @Override
    public AtencionBean convert(Atencion atencion) {
        if (atencion == null) {
            return null;
        }
        AtencionBean atencionBean = new AtencionBean();
        atencionBean.setArea(new AreaConverter().convert(atencion.getArea()));
        atencionBean.setColaborador(new ColaboradorConverter().convert(atencion.getColaborador()));
        atencionBean.setIdAtencion(atencion.getIdAtencion());
        atencionBean.setNuMesa(atencion.getNuMesa());
        return atencionBean;
    }
    
    
    
    
}
