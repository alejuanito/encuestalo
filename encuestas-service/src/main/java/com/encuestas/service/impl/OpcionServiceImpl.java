package com.encuestas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encuestas.data.bean.OpcionBean;
import com.encuestas.data.model.Opcion;
import com.encuestas.data.repository.OpcionRepository;
import com.encuestas.service.OpcionService;
import com.encuestas.service.converter.OpcionModelToBeanConverter;

@Service
public class OpcionServiceImpl implements OpcionService {
    @Autowired
    private OpcionRepository opcionRepository;

    @Override
    public List<OpcionBean> listAll() {
        List<Opcion> opcionList = opcionRepository.findAll();
        return new OpcionModelToBeanConverter().convertList(opcionList);
    }

}
