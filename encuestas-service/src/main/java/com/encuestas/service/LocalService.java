/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service;

import java.util.List;

import com.encuestas.data.bean.LocalBean;

public interface LocalService {

    List<LocalBean> listLocal(String username);

    LocalBean getLocal(String username);

    LocalBean consultaPorId (Integer idLocal);
}
