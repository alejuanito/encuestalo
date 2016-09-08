package com.encuestas.service.converter;

import com.encuestas.data.bean.UsuarioRolBean;
import com.encuestas.data.model.UsuarioRol;

public class UsuarioRolModelToBeanConverter extends AbstractDataConverter<UsuarioRol, UsuarioRolBean> {

    @Override
    public UsuarioRolBean convert(UsuarioRol usuarioRol) {
        if (usuarioRol == null) {
            return null;
        }
        RolModelToBeanConverter rolModelToBeanConverter = new RolModelToBeanConverter();
        UsuarioRolBean usuarioRolBean = new UsuarioRolBean();
        usuarioRolBean.setRol(rolModelToBeanConverter.convert(usuarioRol.getRol()));
        return usuarioRolBean;
    }

}
