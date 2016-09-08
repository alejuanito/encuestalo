/*
O * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service;

import com.encuestas.data.bean.AtencionBean;

public interface AtencionService {
    
    public AtencionBean createAtencion (AtencionBean atencion);
     public AtencionBean getAtencion (Integer idAtencion);
}
