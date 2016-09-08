/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.web.controller.api;

import com.encuestas.data.bean.PlantillaEncuestaBean;
import com.encuestas.service.PlantillaEncuestaService;
import com.encuestas.service.exception.DataValidationErrorException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantillaEncuestaApiController {

    @Autowired
    private PlantillaEncuestaService plantillaEncuestaService;

  @RequestMapping(value = {"/api/plantillaEncuesta"}, method = RequestMethod.GET)
  public List<PlantillaEncuestaBean> plantillaEncuesta(
      @RequestParam(required = false) Integer idLocal) {
    if (idLocal == null) {
      return plantillaEncuestaService.listAll();
    }
    return plantillaEncuestaService.listPreguntaAndRespuesta(idLocal);
  }

    @RequestMapping(value = "/api/plantillaEncuesta/{id}", method = RequestMethod.GET)
    public PlantillaEncuestaBean load(@PathVariable Integer id) {
        return plantillaEncuestaService.load(id);
    }

    @RequestMapping(value = "/api/plantillaEncuesta", method = RequestMethod.POST)
    public PlantillaEncuestaBean guardar(@RequestBody PlantillaEncuestaBean plantillaEncuestaBean) throws DataValidationErrorException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return plantillaEncuestaService.create(plantillaEncuestaBean, user.getUsername());
    }

    @RequestMapping(value = "/api/plantillaEncuesta/{id}", method = RequestMethod.PUT)
    public PlantillaEncuestaBean actualizar(@RequestBody PlantillaEncuestaBean plantillaEncuestaBean) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return plantillaEncuestaService.update(plantillaEncuestaBean, user.getUsername());
    }
    
    @ExceptionHandler({DataValidationErrorException.class})
    @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
    public Map<String, Object> onDataValidationException (DataValidationErrorException dataValidationErrorException) {
    	Map<String, Object> response = new HashMap<>();
    	response.put("errors", dataValidationErrorException.getErrors());
    	return response;
    }
}
