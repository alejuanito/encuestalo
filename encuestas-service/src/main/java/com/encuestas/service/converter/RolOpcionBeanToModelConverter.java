package com.encuestas.service.converter;

import com.encuestas.data.bean.RolOpcionBean;
import com.encuestas.data.model.RolOpcion;

public class RolOpcionBeanToModelConverter extends AbstractDataConverter<RolOpcionBean, RolOpcion> {

  @Override
  public RolOpcion convert(RolOpcionBean rolOpcionBean) {
    if (rolOpcionBean == null) {
      return null;
    }
    RolBeanToModelConverter rolConverter = new RolBeanToModelConverter();
    OpcionBeanToModelConverter opcionConverter = new OpcionBeanToModelConverter();
    RolOpcion rolOpcion = new RolOpcion();
    rolOpcion.setCoOpcion(rolOpcionBean.getCoOpcion());
    rolOpcion.setIdRol(rolOpcionBean.getIdRol());
    rolOpcion.setOpcion(opcionConverter.convert(rolOpcionBean.getOpcion()));
//    rolOpcion.setRol(rolConverter.convert(rolOpcionBean.getRol()));
    return rolOpcion;
  }

}
