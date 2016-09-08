package com.encuestas.service.converter;

import com.encuestas.data.bean.UsuarioBean;
import com.encuestas.data.model.Usuario;

public class UsuarioBeanToModelConverter extends AbstractDataConverter<UsuarioBean, Usuario> {

    @Override
    public Usuario convert(UsuarioBean usuarioBean) {
        if (usuarioBean == null) {
            return null;
        }
        PersonaBeanToModelConverter personaConverter = new PersonaBeanToModelConverter();
        
        Usuario usuario = new Usuario();
        usuario.setPersona(personaConverter.convert(usuarioBean.getPersona()));
        usuario.setEstado(usuarioBean.getEstado());
        usuario.setIdUsuario(usuarioBean.getIdUsuario());
        usuario.setInAdmin(usuarioBean.getInAdmin());
        usuario.setPassword(usuarioBean.getPassword());
        usuario.setUsername(usuarioBean.getUsername());
        return usuario;
    }

}
