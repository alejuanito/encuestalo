package com.encuestas.service.converter;

import java.util.ArrayList;
import java.util.List;

import com.encuestas.data.bean.UsuarioBean;
import com.encuestas.data.model.Usuario;
import com.encuestas.data.model.UsuarioRol;

public class UsuarioModelToBeanConverter implements DataConverter<Usuario, UsuarioBean> {

    @Override
    public UsuarioBean convert(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        PersonaConverter personaConverter = new PersonaConverter();
        EmpresaConverter empresaConverter = new EmpresaConverter();
        UsuarioRolModelToBeanConverter usuarioRolModelToBeanConverter = new UsuarioRolModelToBeanConverter();
        UsuarioBean usuarioBean = new UsuarioBean();
        usuarioBean.setEstado(usuario.getEstado());
        usuarioBean.setIdUsuario(usuario.getIdUsuario());
        usuarioBean.setInAdmin(usuario.getInAdmin());
        usuarioBean.setPassword(usuario.getPassword());
        usuarioBean.setUsername(usuario.getUsername());
        usuarioBean.setPersona(personaConverter.convert(usuario.getPersona()));
        usuarioBean.setEmpresa(empresaConverter.convert(usuario.getEmpresa()));
        
        for (UsuarioRol usuarioRol : usuario.getUsuarioRol()) {
            usuarioBean.getUsuarioRols().add(usuarioRolModelToBeanConverter.convert(usuarioRol));
        }
        return usuarioBean;
    }

    @Override
    public List<UsuarioBean> convertList(List<Usuario> dataList) {
        List<UsuarioBean> result = new ArrayList<>();
        for (Usuario usuario : dataList) {
            result.add(convert(usuario));
        }
        return result;
    }

}
