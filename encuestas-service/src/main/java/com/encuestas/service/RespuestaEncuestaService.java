/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service;

import com.encuestas.data.bean.EncuestaBean;
import java.util.List;

import com.encuestas.data.bean.RespuestaEncuestaBean;

public interface RespuestaEncuestaService {
    
    public RespuestaEncuestaBean createRespuestaEncuesta (RespuestaEncuestaBean encuestaBean);
    public EncuestaBean createListRespuestaEncuesta (List<RespuestaEncuestaBean> listEncuestaBean, String username);
    
    public List<RespuestaEncuestaBean> listarRespestas(Integer idEncuesta);
}
