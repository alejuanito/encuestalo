package com.encuestas.web.controller.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encuestas.data.bean.EncuestaBean;
import com.encuestas.service.EncuestaService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@RestController
public class EncuestaApiController {

    @Autowired
    public EncuestaService encuestaService;

    @RequestMapping(value = "/api/encuestas", method = RequestMethod.GET)
    public List<EncuestaBean> consultaEncuesta(@RequestParam Integer idPlantillaEncuesta) {
        if (idPlantillaEncuesta != null) {
            return encuestaService.consultaEncuesta(new Date(), new Date(), 1, new PageRequest(0, 10));
        }
        return new ArrayList<>();
    }
    
    @RequestMapping(value = "/api/encuestas/correlativo", method = RequestMethod.GET)
    public Integer correlativoEncuesta() {
         User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         return encuestaService.getCorrelativoEncuesta(user.getUsername());
    }

    @RequestMapping(value = "/api/encuestas/{idEncuesta}", method = RequestMethod.GET)
    public EncuestaBean cargarEncuesta(@PathVariable Integer idEncuesta) {
    	return encuestaService.cargarEncuesta(idEncuesta);
    }
}
