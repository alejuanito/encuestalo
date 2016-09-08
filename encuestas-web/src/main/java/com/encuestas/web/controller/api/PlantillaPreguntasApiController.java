/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.web.controller.api;

import com.encuestas.data.bean.PlantillaEncuestaPreguntaBean;
import com.encuestas.service.PlantillaEncuestaPreguntaService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantillaPreguntasApiController {

    @Autowired
    PlantillaEncuestaPreguntaService plantillaEncuestaPreguntaService;

    @RequestMapping(value = { "/api/preguntas" }, method = RequestMethod.GET)
    public List<PlantillaEncuestaPreguntaBean> listPreguntas(@RequestParam(required = false) Integer idPlantillaEncuesta) {
        List<PlantillaEncuestaPreguntaBean> data = new ArrayList<>();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (idPlantillaEncuesta == null) {
            data = plantillaEncuestaPreguntaService.listPreguntaAtencion(user.getUsername());
        } else {
            data = plantillaEncuestaPreguntaService.listPreguntaAtencionByIdPlantillaEncuesta(idPlantillaEncuesta);
        }
        return data;
    }

    @RequestMapping(value = { "/api/preguntas/{idPlantillaEncuestaPregunta}" }, method = RequestMethod.GET)
    public PlantillaEncuestaPreguntaBean load (@PathVariable Integer idPlantillaEncuestaPregunta) {
        return plantillaEncuestaPreguntaService.load(idPlantillaEncuestaPregunta);
    }
    
    @RequestMapping(value = "/api/preguntas", method = RequestMethod.POST)
    public PlantillaEncuestaPreguntaBean crear (@RequestBody PlantillaEncuestaPreguntaBean plantillaEncuestaPreguntaBean) {
        return plantillaEncuestaPreguntaService.crear(plantillaEncuestaPreguntaBean);
    }
    
    @RequestMapping(value = "/api/preguntas/{idPlantillaPreguntaEncuesta}", method = RequestMethod.PUT)
    public PlantillaEncuestaPreguntaBean actualizar (@RequestBody PlantillaEncuestaPreguntaBean plantillaEncuestaPreguntaBean) {
        return plantillaEncuestaPreguntaService.actualizar(plantillaEncuestaPreguntaBean);
    }
    
    @RequestMapping(value = "/api/preguntas/{idPlantillaEncuestaPregunta}", method = RequestMethod.DELETE)
    public Map<String, String> eliminar (@PathVariable Integer idPlantillaEncuestaPregunta) {
    	Map<String, String> response = new HashMap<>();
        plantillaEncuestaPreguntaService.eliminar(idPlantillaEncuestaPregunta);
        response.put("result", "OK");
        return response;
    }

    @RequestMapping(value = { "/api/preguntasReporte" }, method = RequestMethod.GET)
    public List<PlantillaEncuestaPreguntaBean> listPreguntaReporte (@RequestParam Integer idLocal) {
        return plantillaEncuestaPreguntaService.listPreguntaParaReporte(idLocal);
    }
    
}
