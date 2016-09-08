package com.encuestas.service;

import java.util.List;

import com.encuestas.data.bean.UsuarioBean;
import com.encuestas.service.exception.ApplicationException;
import com.encuestas.service.exception.DataValidationErrorException;

public interface UsuarioService {

    public UsuarioBean findByUsername(String username);

    public List<UsuarioBean> listaTodos();

    public UsuarioBean cargarDatosPorId(Integer idUsuario);

    public UsuarioBean crear (UsuarioBean usuarioBean, String usernameCreador, String coCargoColaborador) throws DataValidationErrorException ;
    
    public UsuarioBean actualizar (UsuarioBean usuarioBean, String coCargoColaborador) throws DataValidationErrorException ;
    
    /**
     * Cambia la contraseña verificando la contraseña actual.
     * 
     * @param idUsuario que desea cambiar la contraseña
     * @param oldPassword contraseña anterior, cuando la contraseña
     *  anterior no esta configurada, no se hace verificación 
     * @param newPassword contraseña a cambiar
     * @return usuario
     */
    public UsuarioBean changePassword (Integer idUsuario, String oldPassword, String newPassword, Boolean verifyPassword) throws ApplicationException;
    
}
