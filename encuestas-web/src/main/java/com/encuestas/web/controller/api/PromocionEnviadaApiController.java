/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.encuestas.data.bean.PromocionEnviadaBean;
import com.encuestas.service.PromocionEnviadaService;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PromocionEnviadaApiController {

   
    private final Logger LOGGER = Logger.getLogger(PromocionEnviadaApiController.class);
    @Autowired
    private PromocionEnviadaService promocionEnviadaService;

//    @Autowired
//    FileValidator fileValidator;

    @RequestMapping(value = {"/api/promocionEnviada"}, method = RequestMethod.GET)
    @ResponseBody
    public Page<PromocionEnviadaBean> listPromocion(@RequestParam Integer idPromocion,
                                                    @RequestParam String feInicio, @RequestParam String feFin,
                                                    @RequestParam(required = false) String nuDocumento,
                                                    @RequestParam(required = false, defaultValue = "0") Integer page,
                                                    @RequestParam(required = false, defaultValue = "30") Integer pageSize) {
        if (nuDocumento.length() == 0)
            nuDocumento = null;
        return promocionEnviadaService.listEnviosFiltros(idPromocion, feInicio, feFin, nuDocumento, page, pageSize);

    }


}
