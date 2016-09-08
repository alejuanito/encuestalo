/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.bean.TipoPromocionBean;
import com.encuestas.data.model.TipoPromocion;

/**
 *
 * @author e00309
 */
public class TipoPromocionBeanToModelConverter implements DataConverter<TipoPromocionBean, TipoPromocion> {

    @Override
    public List<TipoPromocion> convertList(List<TipoPromocionBean> dataList) {
        List<TipoPromocion> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (TipoPromocionBean tipo : dataList) {
            data.add(convert(tipo));
        }
        return data;
    }

    @Override
    public TipoPromocion convert(TipoPromocionBean tipo) {
        if (tipo == null) {
            return null;
        }
        TipoPromocion tipoPromocion = new TipoPromocion();
        tipoPromocion.setDeTipoPromocion(tipo.getDeTipoPromocion());
        tipoPromocion.setIdTipoPromocion(tipo.getIdTipoPromocion());
           return tipoPromocion;
    }
    
}
