/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import com.encuestas.data.bean.AreaBean;
import com.encuestas.data.bean.ColaboradorBean;
import com.encuestas.data.bean.EmpresaBean;
import com.encuestas.data.bean.LocalBean;
import com.encuestas.data.bean.UsuarioBean;
import com.encuestas.data.model.Area;
import com.encuestas.data.model.Colaborador;
import com.encuestas.data.model.Empresa;
import com.encuestas.data.model.Local;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author e00309
 */
public class ColaboradorBeanConverter implements DataConverter<ColaboradorBean,Colaborador> {

    @Override
    public List<Colaborador> convertList(List<ColaboradorBean> dataList) {
        List<Colaborador> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }	
        for (ColaboradorBean colaborador : dataList) {
            data.add(convert(colaborador));
        }
        return data;
    }

    @Override
    public Colaborador convert(ColaboradorBean colaborador) {
        if (colaborador == null) {
            return null;
        }
        Colaborador colaboradorBean = new Colaborador();
        colaboradorBean.setIdColaborador(colaborador.getIdColaborador());
        colaboradorBean.setLocal(new LocalBeanConverter().convert(colaborador.getLocal()));
        colaboradorBean.setPersona(new PersonaBeanConverter().convert(colaborador.getPersona()));
       
        return colaboradorBean;
    }
    
}
