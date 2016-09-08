/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service;

import com.encuestas.data.model.Promocion;

/**
 *
 * @author Alejandro
 */
public interface MailService {
//    public boolean send (String subject, String to, String message);
//    public boolean sendWithAttachment (String subject, String to, String message, byte[] attachment, String contentType);
    public boolean enviarPromociones ();
    public boolean enviarPromocionesAdjunto(Promocion promocion, String correos);
}
