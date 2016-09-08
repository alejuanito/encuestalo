package com.encuestas.service.converter;

import java.util.ArrayList;

import com.encuestas.data.bean.RolBean;
import com.encuestas.data.bean.RolOpcionBean;
import com.encuestas.data.model.Rol;
import com.encuestas.data.model.RolOpcion;

public class RolBeanToModelConverter extends AbstractDataConverter<RolBean, Rol> {

    @Override
    public Rol convert(RolBean rolBean) {
        if (rolBean == null) {
            return null;
        }
        RolOpcionBeanToModelConverter rolOpcionConverter = new RolOpcionBeanToModelConverter();
        Rol rol = new Rol();
        rol.setEstado(rolBean.getEstado());
        rol.setIdRol(rolBean.getIdRol());
        rol.setNombre(rolBean.getNombre());
        
        rol.setRolOpciones(new ArrayList<RolOpcion>());
        
//        for (RolOpcionBean rolOpcionBean : rolBean.getRolOpciones()) {
//          rol.getRolOpciones().add(rolOpcionConverter.convert(rolOpcionBean));
//        }
        
        return rol;
    }

}
