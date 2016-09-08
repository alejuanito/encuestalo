/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encuestas.data.bean.MotivoPromocionBean;
import com.encuestas.service.MotivoPromocionService;


@Controller
public class TipoPromocionApiController {

    @Autowired
    private MotivoPromocionService motivoPromocionService;

    @RequestMapping(value = {"/api/motivo-promocion"}, method = RequestMethod.GET)
    @ResponseBody
    public List<MotivoPromocionBean> listMotivoPromocion() {    	
        return motivoPromocionService.listAll();
    }

}
