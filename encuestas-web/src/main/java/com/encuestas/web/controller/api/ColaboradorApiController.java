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

import com.encuestas.data.bean.ColaboradorBean;
import com.encuestas.service.ColaboradorService;


@Controller
public class ColaboradorApiController {

    @Autowired
    private ColaboradorService colaboradorService;

    @RequestMapping(value = {"/api/colaborador"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ColaboradorBean> listMozoLocal() {
    	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return colaboradorService.listMozoLocal(user.getUsername());
    }

}
