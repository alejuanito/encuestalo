/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.bean.MotivoPromocionBean;
import com.encuestas.data.bean.TipoPromocionBean;
import com.encuestas.data.model.MotivoPromocion;
import com.encuestas.data.model.TipoPromocion;

/**
 *
 * @author e00309
 */
public class MotivoPromocionBeanToModelConverter implements DataConverter<MotivoPromocionBean, MotivoPromocion> {

    @Override
    public List<MotivoPromocion> convertList(List<MotivoPromocionBean> dataList) {
        List<MotivoPromocion> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (MotivoPromocionBean tipo : dataList) {
            data.add(convert(tipo));
        }
        return data;
    }

    @Override
    public MotivoPromocion convert(MotivoPromocionBean tipo) {
        if (tipo == null) {
            return null;
        }
        MotivoPromocion tipoPromocion = new MotivoPromocion();
        tipoPromocion.setDeMotivoPromocion(tipo.getDeMotivoPromocion());
        tipoPromocion.setIdMotivoPromocion(tipo.getIdMotivoPromocion());
           return tipoPromocion;
    }
    
}
