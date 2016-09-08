package com.encuestas.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.encuestas.data.bean.OpcionBean;
import com.encuestas.service.OpcionService;

@RestController
public class OpcionApiController {
    @Autowired
    private OpcionService opcionService;
    
    @RequestMapping(value="/api/opcion", method=RequestMethod.GET)
    public List<OpcionBean> listar () {
        return opcionService.listAll();
    }

}
