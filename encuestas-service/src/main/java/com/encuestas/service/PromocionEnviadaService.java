/*
O * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service;

import com.encuestas.data.bean.PromocionEnviadaBean;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface PromocionEnviadaService {
    
    public List<PromocionEnviadaBean> listEnvios (Integer idEmpresa);
    //public List<PromocionEnviadaBean> listEnviosFiltros(Integer idPromocion,
    //        String feInicio, String feFin, String nuDocumento);

    @Transactional
    Page<PromocionEnviadaBean> listEnviosFiltros(Integer idPromocion,
                                                 String feInicio, String feFin, String nuDocumento, Integer page, Integer pageSize);
}
