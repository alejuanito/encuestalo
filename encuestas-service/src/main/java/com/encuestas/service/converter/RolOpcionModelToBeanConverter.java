package com.encuestas.service.converter;

import com.encuestas.data.bean.RolOpcionBean;
import com.encuestas.data.model.RolOpcion;

public class RolOpcionModelToBeanConverter extends AbstractDataConverter<RolOpcion, RolOpcionBean> {

    @Override
    public RolOpcionBean convert(RolOpcion rolOpcion) {
        if (rolOpcion == null) {
            return null;
        }
        OpcionModelToBeanConverter opcionModelToBeanConverter = new OpcionModelToBeanConverter();
        RolOpcionBean rolOpcionBean = new RolOpcionBean();
        rolOpcionBean.setOpcion(opcionModelToBeanConverter.convert(rolOpcion.getOpcion()));
        return rolOpcionBean;
    }

}
