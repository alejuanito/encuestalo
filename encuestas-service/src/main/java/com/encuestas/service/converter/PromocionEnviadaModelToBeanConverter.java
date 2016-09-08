/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.bean.MotivoPromocionBean;
import com.encuestas.data.bean.PromocionEnviadaBean;
import com.encuestas.data.model.MotivoPromocion;
import com.encuestas.data.model.PromocionEnviada;


public class PromocionEnviadaModelToBeanConverter implements DataConverter<PromocionEnviada, PromocionEnviadaBean> {

    @Override
    public List<PromocionEnviadaBean> convertList(List<PromocionEnviada> dataList) {
        List<PromocionEnviadaBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (PromocionEnviada tipo : dataList) {
            data.add(convert(tipo));
        }
        return data;
    }

    @Override
    public PromocionEnviadaBean convert(PromocionEnviada tipo) {
        if (tipo == null) {
            return null;
        }
        PromocionEnviadaBean promocionEnviada = new PromocionEnviadaBean();
        promocionEnviada.setCliente(new ClienteConverter().convert(tipo.getCliente()));
        promocionEnviada.setFeEnvio(tipo.getFeEnvio());
        promocionEnviada.setIdPromocionEnviada(tipo.getIdPromocionEnviada());
        promocionEnviada.setPromocion(new PromocionModelToBeanConverter().convert(tipo.getPromocion()));
        promocionEnviada.setUsuario(new UsuarioModelToBeanConverter().convert(tipo.getUsuario()));
       
        return promocionEnviada;
    }
    
}
