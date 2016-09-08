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

import com.encuestas.data.bean.TipoPromocionBean;
import com.encuestas.service.TipoPromocionService;


@Controller
public class MotivoPromocionApiController {

    @Autowired
    private TipoPromocionService tipoPromocionService;

    @RequestMapping(value = {"/api/tipo-promocion"}, method = RequestMethod.GET)
    @ResponseBody
    public List<TipoPromocionBean> listTipoPromocion() {    	
        return tipoPromocionService.listAll();
    }

}
