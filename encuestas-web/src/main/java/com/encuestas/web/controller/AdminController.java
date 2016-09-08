/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.web.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encuestas.data.bean.TipoDocumentoBean;
import com.encuestas.data.bean.UsuarioBean;
import com.encuestas.service.TipoDocumentoService;
import com.encuestas.service.UsuarioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author jaxkodex
 */
@Controller
public class AdminController {
    private static final Logger LOGGER = LogManager.getLogger(AdminController.class);
    @Autowired
    private TipoDocumentoService tipoDocumentoService;
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/admin")
    public String index(Model model) {
        List<TipoDocumentoBean> tipoDocumentoList = tipoDocumentoService.listAll();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsuarioBean usuarioBean = usuarioService.findByUsername(auth.getName());
        
        ObjectMapper mapper = new ObjectMapper();
        try {
            model.addAttribute("tipoDocumentoData", mapper.writeValueAsString(tipoDocumentoList));
            model.addAttribute("usuarioData", mapper.writeValueAsString(usuarioBean));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "admin/index";
    }

}
