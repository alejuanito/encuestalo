package com.encuestas.web.controller.api;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.encuestas.data.bean.UsuarioBean;
import com.encuestas.service.UsuarioService;
import com.encuestas.service.exception.ApplicationException;

@RestController
public class MeApiController {
  @Autowired
  private UsuarioService usuarioService;
  
  @RequestMapping(value = "/api/me/password", method = RequestMethod.POST)
  public Map<String, Object> changeMyPassword (@RequestParam String newPassword, @RequestParam String oldPassword, Principal principal) {
    UsuarioBean usuario = usuarioService.findByUsername(principal.getName());
    usuarioService.changePassword(usuario.getIdUsuario(), oldPassword, newPassword, true);
    Map<String, Object> map = new HashMap<>();
    map.put("success", true);
    return map;
  }
  
  @ExceptionHandler({ApplicationException.class})
  @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
  public Map<String, Object> onDataValidationException (ApplicationException ex) {
      Map<String, Object> response = new HashMap<>();
      response.put("mensaje", ex.getMessage());
      return response;
  }

}
