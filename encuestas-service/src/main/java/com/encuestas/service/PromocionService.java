/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service;

import java.util.List;

import com.encuestas.data.bean.PromocionBean;
import com.encuestas.service.exception.DataValidationErrorException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public interface PromocionService {
    
	public List<PromocionBean> listAll();
        public List<PromocionBean> listPromocion(String user);
        public PromocionBean load(Integer id);
	public PromocionBean create(PromocionBean promocionBean, String user) ;
	public PromocionBean update(PromocionBean promocionBean, String user) ;
        public Boolean saveImage(String noImage, InputStream inputStream, String user) throws RuntimeException, IOException;
        public Boolean enviarPromociones();
         public PromocionBean desactivar(Integer idPromocion);
       

}
