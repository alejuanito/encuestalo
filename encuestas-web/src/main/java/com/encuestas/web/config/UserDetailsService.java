package com.encuestas.web.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.encuestas.util.enums.EstadoEnum;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.encuestas.data.bean.OpcionBean;
import com.encuestas.data.bean.RolOpcionBean;
import com.encuestas.data.bean.UsuarioBean;
import com.encuestas.data.bean.UsuarioRolBean;
import com.encuestas.service.UsuarioService;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{
    private static final Logger LOGGER = Logger.getLogger(UserDetailsService.class);
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioBean usuario = usuarioService.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado :(");
        }
        LOGGER.trace(String.format("Autenticando al usuario %s", username)); 
        List<GrantedAuthority> authorities = new ArrayList<>();
        Map<String, OpcionBean> opcionMap = new HashMap<>();
        for (UsuarioRolBean usuarioRolBean : usuario.getUsuarioRols()) {
            for (RolOpcionBean rolOpcionBean : usuarioRolBean.getRol().getRolOpciones()) {
                OpcionBean opcion = rolOpcionBean.getOpcion();
                String codigo = opcion.getCodigo();
                if (opcionMap.get(codigo) == null) {
                    opcionMap.put(codigo, opcion);
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(codigo);
                    authorities.add(grantedAuthority);
                    LOGGER.trace(String.format("Dando permiso: %s", codigo));
                }
            }
        }
        
        
        UserDetails details = new User(username, usuario.getPassword(), EstadoEnum.ACTIVO.getCodigo().equals(usuario.getEstado()), true, true, true, authorities);
        return details;
    }

}
