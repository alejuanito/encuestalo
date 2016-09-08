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


public class PromocionEnviadaBeanConverter implements DataConverter<PromocionEnviadaBean,PromocionEnviada> {

    @Override
    public List<PromocionEnviada> convertList(List<PromocionEnviadaBean> dataList) {
        List<PromocionEnviada> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }	
        for (PromocionEnviadaBean local : dataList) {
            data.add(convert(local));
        }
        return data;
    }

    @Override
    public PromocionEnviada convert(PromocionEnviadaBean promocion) {
        if (promocion == null) {
            return null;
        }
        PromocionEnviada promocionBean = new PromocionEnviada();
        promocionBean.setCliente(new ClienteBeanConverter().convert(promocion.getCliente()));
        promocionBean.setFeEnvio(promocion.getFeEnvio());
        promocionBean.setIdPromocionEnviada(promocion.getIdPromocionEnviada());
        promocionBean.setPromocion(new PromocionBeanToModelConverter().convert(promocion.getPromocion()));
        
       
        return promocionBean;
    }
    
}
