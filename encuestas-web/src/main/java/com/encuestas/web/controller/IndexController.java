package com.encuestas.web.controller;

import com.encuestas.data.bean.LocalBean;
import com.encuestas.data.repository.EncuestaRepository;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encuestas.service.LocalService;
import com.encuestas.util.DateUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by JaxKodex on 25/10/2015.
 */
@Controller
public class IndexController {
    private static final Logger LOGGER = LogManager.getLogger(IndexController.class);
    @Autowired
    private LocalService localService;
    @Autowired
    private EncuestaRepository encuestaRepository;

//    private static final Logger LOGGER = Loggger.getLogger(IndexController.class);

    @RequestMapping(value = "/")
    public String index(Model model) {
        LOGGER.debug("Iniciando logger");
        
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ObjectMapper mapper;
	mapper = new ObjectMapper();
        Map<String, String> userData = new HashMap<String, String>();
        LocalBean local = localService.getLocal(user.getUsername());
        Integer nuCorrelativo = encuestaRepository.findCorrelativo(local.getIdLocal())+1;
        userData.put("username", user.getUsername());
        userData.put("local", local.getNoLocal());
        userData.put("idLocal", local.getIdLocal().toString());
        userData.put("nuLocal", local.getNuLocal().toString());
        userData.put("date", DateUtils.formatToDateOnly(new Date()));
        userData.put("nuCorrelativoEncuesta", nuCorrelativo.toString());
        userData.put("idAtencion", "0");
        try {
                model.addAttribute("userData", mapper.writeValueAsString(userData));
        } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        
        return "index";
    }
}
