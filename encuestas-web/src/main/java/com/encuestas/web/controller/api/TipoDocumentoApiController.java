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

import com.encuestas.data.bean.TipoDocumentoBean;
import com.encuestas.service.TipoDocumentoService;


@Controller
public class TipoDocumentoApiController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @RequestMapping(value = {"/api/tipoDocumento"}, method = RequestMethod.GET)
    @ResponseBody
    public List<TipoDocumentoBean> listAll() {
        return tipoDocumentoService.listAll();
    }

}
