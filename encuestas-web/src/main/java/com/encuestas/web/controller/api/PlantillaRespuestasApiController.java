/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.web.controller.api;

import com.encuestas.data.bean.AreaBean;
import com.encuestas.data.bean.AtencionBean;
import com.encuestas.data.bean.ColaboradorBean;
import com.encuestas.data.bean.EmpresaBean;
import com.encuestas.data.bean.PlantillaEncuestaBean;
import com.encuestas.data.bean.PlantillaEncuestaRespuestaBean;
import com.encuestas.service.AreaService;
import com.encuestas.service.AtencionService;
import com.encuestas.service.EmpresaService;
import com.encuestas.service.PlantillaEncuestaPreguntaService;
import com.encuestas.service.PlantillaEncuestaRespuestaService;
import com.encuestas.service.PlantillaEncuestaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@Controller
public class PlantillaRespuestasApiController {

    @Autowired PlantillaEncuestaRespuestaService plantillaEncuestaRespuestaService;

    @RequestMapping(value = {"/api/respuestas"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PlantillaEncuestaRespuestaBean>  listRespuestas(@RequestParam Integer idPregunta) {
        return plantillaEncuestaRespuestaService.listRespuesta(idPregunta);
    }
    
    
    
     

}
