/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.web.controller.api;

import com.encuestas.data.bean.EncuestaBean;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encuestas.data.bean.RespuestaEncuestaBean;
import com.encuestas.service.RespuestaEncuestaService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@RestController
public class RespuestaEncuestaApiController {
    @Autowired
    private RespuestaEncuestaService respuestaEncuestaService;
    
    @RequestMapping(value = "/api/respuestaEncuesta", method = RequestMethod.GET)
    public List<RespuestaEncuestaBean> listarRespuestaEncuesta (@RequestParam(required = false) Integer idEncuesta) {
        if (idEncuesta != null) {
            return respuestaEncuestaService.listarRespestas(idEncuesta);
        }
        return new ArrayList<>();
    }

    @RequestMapping(value = "/api/respuestaEncuesta", method = RequestMethod.POST)
    public EncuestaBean guardarRespuestas(@RequestBody List<RespuestaEncuestaBean> listRespuestas) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return respuestaEncuestaService.createListRespuestaEncuesta(listRespuestas,user.getUsername());
    }
}
