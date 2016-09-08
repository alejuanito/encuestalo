/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.bean.MotivoPromocionBean;
import com.encuestas.data.model.MotivoPromocion;

/**
 *
 * @author e00309
 */
public class MotivoPromocionModelToBeanConverter implements DataConverter<MotivoPromocion, MotivoPromocionBean> {

    @Override
    public List<MotivoPromocionBean> convertList(List<MotivoPromocion> dataList) {
        List<MotivoPromocionBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (MotivoPromocion tipo : dataList) {
            data.add(convert(tipo));
        }
        return data;
    }

    @Override
    public MotivoPromocionBean convert(MotivoPromocion tipo) {
        if (tipo == null) {
            return null;
        }
        MotivoPromocionBean tipoPromocion = new MotivoPromocionBean();
        tipoPromocion.setDeMotivoPromocion(tipo.getDeMotivoPromocion());
        tipoPromocion.setIdMotivoPromocion(tipo.getIdMotivoPromocion());
           return tipoPromocion;
    }
    
}
