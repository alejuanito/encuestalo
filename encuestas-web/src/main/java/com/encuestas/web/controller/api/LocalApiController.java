/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encuestas.data.bean.LocalBean;
import com.encuestas.service.EmpresaService;
import com.encuestas.service.LocalService;


@Controller
public class LocalApiController {

    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private LocalService localService;
    
    @RequestMapping(value = {"/api/local"}, method = RequestMethod.GET)
    @ResponseBody
    public List<LocalBean> listLocal() {
    	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return localService.listLocal(user.getUsername());
    }



}
