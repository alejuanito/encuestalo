/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.converter;

import com.encuestas.data.bean.AreaBean;
import com.encuestas.data.bean.AtencionBean;
import com.encuestas.data.bean.EmpresaBean;
import com.encuestas.data.model.Area;
import com.encuestas.data.model.Atencion;
import com.encuestas.data.model.Empresa;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;



/**
 *
 * @author e00309
 */
public class AtencionBeanConverter implements DataConverter<AtencionBean, Atencion> {

	
	private final Logger LOGGER = Logger.getLogger(AtencionBeanConverter.class);
	
    @Override
    public List<Atencion> convertList(List<AtencionBean> dataList) {
        List<Atencion> data = new ArrayList<>();
        if (dataList == null) {
            return data;
        }
        for (AtencionBean atencion : dataList) {
            data.add(convert(atencion));
        }
        return data;
    }

    @Override
    public Atencion convert(AtencionBean atencion) {
        if (atencion == null) {
            return null;
        }
        
        Atencion atencionBean = new Atencion();
        atencionBean.setArea(new AreaBeanConverter().convert(atencion.getArea()));
       
        atencionBean.setColaborador(new ColaboradorBeanConverter().convert(atencion.getColaborador()));
        atencionBean.setIdAtencion(atencion.getIdAtencion());
        atencionBean.setNuMesa(atencion.getNuMesa());
        return atencionBean;
    }
    
    
    
    
}
