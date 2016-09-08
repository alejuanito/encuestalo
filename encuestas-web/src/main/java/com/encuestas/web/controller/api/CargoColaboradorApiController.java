package com.encuestas.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encuestas.data.bean.CargoColaboradorBean;
import com.encuestas.service.CargoColaboradorService;

@RestController
public class CargoColaboradorApiController {
    @Autowired
    private CargoColaboradorService cargoColaboradorService;

    @RequestMapping(value = "/api/cargocolaborador")
    public List<CargoColaboradorBean> listar () {
        return cargoColaboradorService.listar();
    }
}
