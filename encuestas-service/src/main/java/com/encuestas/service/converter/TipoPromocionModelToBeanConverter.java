/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import com.encuestas.data.bean.EmpresaBean;
import com.encuestas.data.bean.TipoPromocionBean;
import com.encuestas.data.model.Empresa;
import com.encuestas.data.model.TipoPromocion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e00309
 */
public class TipoPromocionModelToBeanConverter implements DataConverter<TipoPromocion, TipoPromocionBean> {

    @Override
    public List<TipoPromocionBean> convertList(List<TipoPromocion> dataList) {
        List<TipoPromocionBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (TipoPromocion tipo : dataList) {
            data.add(convert(tipo));
        }
        return data;
    }

    @Override
    public TipoPromocionBean convert(TipoPromocion tipo) {
        if (tipo == null) {
            return null;
        }
        TipoPromocionBean tipoPromocion = new TipoPromocionBean();
        tipoPromocion.setDeTipoPromocion(tipo.getDeTipoPromocion());
        tipoPromocion.setIdTipoPromocion(tipo.getIdTipoPromocion());
           return tipoPromocion;
    }
    
}
