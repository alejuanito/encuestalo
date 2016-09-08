package com.encuestas.service.converter;

import com.encuestas.data.bean.OpcionBean;
import com.encuestas.data.model.Opcion;

public class OpcionModelToBeanConverter extends AbstractDataConverter<Opcion, OpcionBean> {

    @Override
    public OpcionBean convert(Opcion opcion) {
        if (opcion == null) {
            return null;
        }
        OpcionBean opcionBean = new OpcionBean();
        opcionBean.setCodigo(opcion.getCodigo());
        opcionBean.setEstado(opcion.getEstado());
        opcionBean.setNombre(opcion.getNombre());
        opcionBean.setUrl(opcion.getUrl());
        opcionBean.setNoIcon(opcion.getNoIcon());
        return opcionBean;
    }

}
