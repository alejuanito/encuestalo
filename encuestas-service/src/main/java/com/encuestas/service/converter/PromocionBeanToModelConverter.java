/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.bean.PromocionBean;
import com.encuestas.data.model.Promocion;


public class PromocionBeanToModelConverter implements DataConverter<PromocionBean, Promocion> {

    @Override
    public List<Promocion> convertList(List<PromocionBean> dataList) {
        List<Promocion> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (PromocionBean tipo : dataList) {
            data.add(convert(tipo));
        }
        return data;
    }

    @Override
    public Promocion convert(PromocionBean promocionBean) {
        if (promocionBean == null) {
            return null;
        }
        Promocion promo = new Promocion();
        promo.setCoPromocion(promocionBean.getCoPromocion());
        promo.setDeDescripcion(promocionBean.getDeDescripcion());
        promo.setDeTitulo(promocionBean.getDeTitulo());
        promo.setFeFin(promocionBean.getFeFin());
        promo.setFeInicio(promocionBean.getFeInicio());
        promo.setHrEnvio(promocionBean.getHrEnvio());
        promo.setIdPromocion(promocionBean.getIdPromocion());
        promo.setNoImagen(promocionBean.getNoImagen());
        promo.setLocal(new LocalBeanConverter().convert(promocionBean.getLocal()));
        promo.setMotivoPromocion(new MotivoPromocionBeanToModelConverter().convert(promocionBean.getMotivoPromocion()));
        promo.setTipoPromocion(new TipoPromocionBeanToModelConverter().convert(promocionBean.getTipoPromocion()));        
        promo.setEsPromocion(promocionBean.getEsPromocion());
        return promo;
    }
    
}
