/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.web.controller.api;

import com.encuestas.data.bean.EmpresaBean;
import com.encuestas.service.EmpresaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author e00309
 */
@Controller
public class EmpresaApiController {

    @Autowired
    private EmpresaService empresaService;

//    @RequestMapping(name = "/api/empresa", method = RequestMethod.GET)
//    @ResponseBody
//    public List<EmpresaBean> listAll() {
//        return empresaService.listAll();
//    }

}
