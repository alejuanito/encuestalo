package com.encuestas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encuestas.data.bean.CargoColaboradorBean;
import com.encuestas.data.repository.CargoColaboradorRepository;
import com.encuestas.service.CargoColaboradorService;
import com.encuestas.service.converter.CargoColaboradorModelToBeanConverter;

@Service
public class CargoColaboradorServiceImpl implements CargoColaboradorService {
    @Autowired
    private CargoColaboradorRepository cargoColaboradorRepository;

    @Override
    public List<CargoColaboradorBean> listar() {
        CargoColaboradorModelToBeanConverter converter = new CargoColaboradorModelToBeanConverter();
        return converter.convertList(cargoColaboradorRepository.findAll());
    }

}
