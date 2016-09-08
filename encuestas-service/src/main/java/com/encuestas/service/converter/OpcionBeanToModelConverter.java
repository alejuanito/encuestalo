package com.encuestas.service.converter;

import com.encuestas.data.bean.OpcionBean;
import com.encuestas.data.model.Opcion;

public class OpcionBeanToModelConverter extends AbstractDataConverter<OpcionBean, Opcion> {

  @Override
  public Opcion convert(OpcionBean opcionBean) {
    if (opcionBean == null) {
      return null;
    }
    Opcion opcion = new Opcion();
    opcion.setCodigo(opcionBean.getCodigo());
    opcion.setEstado(opcionBean.getEstado());
    opcion.setNombre(opcionBean.getNombre());
    opcion.setUrl(opcionBean.getUrl());
    opcion.setNoIcon(opcionBean.getNoIcon());
    return opcion;
  }

}
