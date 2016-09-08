/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import com.encuestas.data.bean.EmpresaBean;
import com.encuestas.data.model.Empresa;
import com.encuestas.data.repository.EmpresaRepository;
import com.encuestas.service.EmpresaService;
import com.encuestas.service.converter.EmpresaConverter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author e00309
 */
@Service
public class EmpresaServiceImpl implements EmpresaService{
    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<EmpresaBean> listAll() {
        List<Empresa> empresaList = empresaRepository.findAll();
        return new EmpresaConverter().convertList(empresaList);
    }
    
}
