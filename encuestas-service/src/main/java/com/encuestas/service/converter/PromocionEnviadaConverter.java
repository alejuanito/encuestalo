/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.bean.PromocionEnviadaBean;
import com.encuestas.data.model.PromocionEnviada;


public class PromocionEnviadaConverter implements DataConverter<PromocionEnviada,PromocionEnviadaBean> {

    @Override
    public List<PromocionEnviadaBean> convertList(List<PromocionEnviada> dataList) {
        List<PromocionEnviadaBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }	
        for (PromocionEnviada local : dataList) {
            data.add(convert(local));
        }
        return data;
    }

    @Override
    public PromocionEnviadaBean convert(PromocionEnviada promocion) {
        if (promocion == null) {
            return null;
        }
        PromocionEnviadaBean promocionBean = new PromocionEnviadaBean();
        promocionBean.setCliente(new ClienteConverter().convert(promocion.getCliente()));
        promocionBean.setFeEnvio(promocion.getFeEnvio());
        promocionBean.setIdPromocionEnviada(promocion.getIdPromocionEnviada());
        promocionBean.setPromocion(new PromocionModelToBeanConverter().convert(promocion.getPromocion()));
        promocionBean.setUsuario(new UsuarioModelToBeanConverter().convert(promocion.getUsuario()));
        
       
        return promocionBean;
    }
    
}
