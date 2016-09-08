package com.encuestas.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.encuestas.data.bean.UsuarioBean;
import com.encuestas.service.UsuarioService;
import com.encuestas.service.exception.ApplicationException;
import com.encuestas.service.exception.DataValidationErrorException;

@RestController
public class UsuarioApiController {
  @Autowired
  private UsuarioService usuarioService;

  @RequestMapping(value = "/api/usuarios", method = RequestMethod.GET)
  public List<UsuarioBean> listarUsuarios() {
    return usuarioService.listaTodos();
  }

  @RequestMapping(value = "/api/usuarios/{idUsuario}", method = RequestMethod.GET)
  public UsuarioBean cargarUsuario(@PathVariable Integer idUsuario) {
    return usuarioService.cargarDatosPorId(idUsuario);
  }

  @RequestMapping(value = "/api/usuarios", method = RequestMethod.POST)
  public UsuarioBean crear(@RequestBody UsuarioBean usuarioBean,
      @RequestHeader String coCargoColaborador) throws DataValidationErrorException, ApplicationException {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return usuarioService.crear(usuarioBean, auth.getName(), coCargoColaborador);
  }

  @RequestMapping(value = "/api/usuarios/{idUsuario}", method = RequestMethod.PUT)
  public UsuarioBean actualizar(@RequestBody UsuarioBean usuarioBean,
      @RequestHeader String coCargoColaborador,
      @RequestHeader(required = false) Boolean changePassword,
      @RequestHeader(required = false) String oldPassword) throws DataValidationErrorException {
    if (changePassword != null && changePassword) {
      return usuarioService.changePassword(usuarioBean.getIdUsuario(), oldPassword, usuarioBean.getPassword(), false);
    }
    return usuarioService.actualizar(usuarioBean, coCargoColaborador);
  }

  @ExceptionHandler({DataValidationErrorException.class})
  @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
  public Map<String, Object> onDataValidationException(DataValidationErrorException dataValidationErrorException) {
    Map<String, Object> response = new HashMap<>();
    response.put("errors", dataValidationErrorException.getErrors());
    return response;
  }

  @ExceptionHandler({ApplicationException.class})
  @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
  public Map<String, Object> onApplicationException(ApplicationException applicationException) {
    Map<String, Object> response = new HashMap<>();
    response.put("error", applicationException.getMessage());
    return response;
  }
}
