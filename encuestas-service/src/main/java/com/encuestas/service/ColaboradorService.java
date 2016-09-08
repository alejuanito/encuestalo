/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service;

import java.util.List;

import com.encuestas.data.bean.ColaboradorBean;

public interface ColaboradorService {
    
	public List<ColaboradorBean> listMozoLocal(String username);
	public ColaboradorBean getColaborador(String username);
}
