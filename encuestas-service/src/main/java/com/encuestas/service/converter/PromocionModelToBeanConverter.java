/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.bean.PromocionBean;
import com.encuestas.data.bean.UsuarioBean;
import com.encuestas.data.model.Promocion;
import com.encuestas.service.impl.PromocionServiceImpl;
import org.apache.log4j.Logger;


public class PromocionModelToBeanConverter implements DataConverter<Promocion, PromocionBean> {
    private final Logger LOGGER = Logger.getLogger(PromocionModelToBeanConverter.class);
    @Override
    public List<PromocionBean> convertList(List<Promocion> dataList) {
        List<PromocionBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (Promocion tipo : dataList) {
            data.add(convert(tipo));
        }
        return data;
    }

    @Override
    public PromocionBean convert(Promocion promocionBean) {
        if (promocionBean == null) {
            return null;
        }
        PromocionBean promo = new PromocionBean();
        promo.setCoPromocion(promocionBean.getCoPromocion());
        promo.setDeDescripcion(promocionBean.getDeDescripcion());
        promo.setDeTitulo(promocionBean.getDeTitulo());
        promo.setFeInicioString(promocionBean.getFeInicio().toString());
        promo.setFeFinString(promocionBean.getFeFin().toString());
        promo.setFeFin(promocionBean.getFeFin());
        promo.setFeInicio(promocionBean.getFeInicio());
        promo.setHrEnvio(promocionBean.getHrEnvio());
        promo.setIdPromocion(promocionBean.getIdPromocion());
        promo.setNoImagen(promocionBean.getNoImagen());
        promo.setLocal(new LocalConverter().convert(promocionBean.getLocal()));
        promo.setMotivoPromocion(new MotivoPromocionModelToBeanConverter().convert(promocionBean.getMotivoPromocion()));
        promo.setTipoPromocion(new TipoPromocionModelToBeanConverter().convert(promocionBean.getTipoPromocion()));        
        promo.setEsPromocion(promocionBean.getEsPromocion());
        if(promocionBean.getUsuario()!=null){
            promo.setUserRegister(promocionBean.getUsuario().getUsername());
        }
       
        return promo;
    }
    
}
