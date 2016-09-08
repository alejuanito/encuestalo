/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.bean.ColaboradorBean;
import com.encuestas.data.model.Colaborador;

/**
 *
 * @author e00309
 */
public class ColaboradorConverter implements DataConverter<Colaborador,ColaboradorBean> {

    @Override
    public List<ColaboradorBean> convertList(List<Colaborador> dataList) {
        List<ColaboradorBean> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }	
        for (Colaborador colaborador : dataList) {
            data.add(convert(colaborador));
        }
        return data;
    }

    @Override
    public ColaboradorBean convert(Colaborador colaborador) {
        if (colaborador == null) {
            return null;
        }
        CargoColaboradorModelToBeanConverter converter = new CargoColaboradorModelToBeanConverter();
        ColaboradorBean colaboradorBean = new ColaboradorBean();
        colaboradorBean.setIdColaborador(colaborador.getIdColaborador());
        colaboradorBean.setLocal(new LocalConverter().convert(colaborador.getLocal()));
        colaboradorBean.setPersona(new PersonaConverter().convert(colaborador.getPersona()));
        // colaboradorBean.setUsuario(new UsuarioModelToBeanConverter().convert(colaborador.getUsuario()));
        colaboradorBean.setCargoColaboradorBean(converter.convert(colaborador.getCargoColaborador()));
        return colaboradorBean;
    }
    
}
