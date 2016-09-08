package com.encuestas.service.converter;

import com.encuestas.data.bean.RolBean;
import com.encuestas.data.model.Rol;
import com.encuestas.data.model.RolOpcion;

public class RolModelToBeanConverter extends AbstractDataConverter<Rol, RolBean> {

    @Override
    public RolBean convert(Rol rol) {
        if (rol == null) {
            return null;
        }
        RolOpcionModelToBeanConverter rolOpcionModelToBeanConverter = new RolOpcionModelToBeanConverter();
        RolBean rolBean = new RolBean();
        rolBean.setEstado(rol.getEstado());
        rolBean.setIdRol(rol.getIdRol());
        rolBean.setNombre(rol.getNombre());
        
        for (RolOpcion rolOpcion : rol.getRolOpciones()) {
            rolBean.getRolOpciones().add(rolOpcionModelToBeanConverter.convert(rolOpcion));
        }
        return rolBean;
    }

}
