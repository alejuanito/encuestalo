/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.service.impl;

import com.encuestas.data.model.Promocion;
import com.encuestas.service.MailService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
import java.io.File;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alejandro
 */
@Service
public class MailServiceImpl implements MailService {

    private final Logger LOGGER = Logger.getLogger(MailServiceImpl.class);

    @Value("${email.mailgun.apiKey}")
    private String mailgunApiKey;
    
    @Value("${email.root.folderImage}")
    private String rootFolderImage;

    @Value("${email.mailgun.host}")
    private String mailgunHost;
    
    @Value("${email.mailgun.emailFrom}")
    private String emailFrom;
    
    @Override
    public boolean enviarPromociones() {
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("api",mailgunApiKey));

        WebResource webResource = client.resource(mailgunHost);

        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("from", "jcondori@certicom.com.pe");
        formData.add("to", "alejandro <alejandrojcc@gmail.com>,jorgito <jvilca@certicom.com.pe>");
        formData.add("subject", "Prueba");
        formData.add("html", "Hola");

        ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, formData);
        String output = clientResponse.getEntity(String.class);

        LOGGER.info("Email sent successfully : " + output);

        return true;
    }

    @Override
    @Transactional
    public boolean enviarPromocionesAdjunto(Promocion promocion, String correos) {

        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("api",mailgunApiKey));
        WebResource webResource = client.resource(mailgunHost);
        FormDataMultiPart form = new FormDataMultiPart();
        form.field("from", " El Piombino <"+ emailFrom + ">");
        form.field("to"," El Piombino <"+ emailFrom + ">");
        form.field("bcc", correos);
        form.field("subject", promocion.getDeTitulo());
        form.field("text", "Testing some Mailgun awesomness!");
        form.field("html", "<html> <head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/><title>Promocion</title>\n" +
                " \n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" +
                " \n" +
                "</head>\n" +
                "\n" +
                "<body bgcolor=\"#EDE4DB\" style=\"margin: 0; padding: 0;\">\n" +
                " \n" +
                " <table  cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                " \n" +
                "<tr>\n" +
                " <td style=\"padding: 25px 0 0 50px;\">\n" +                
                " <img src=\"cid:logoPiombino.png\" alt=\"Pionbino Mail\" style=\"display: block;\" />" + 
                " Estimado Cliente, tenemos una nueva promocion para ti.\n" +
                "   </td>\n" +
                " \n" +
                "</tr>\n" +
                "<tr>\n" +
                " \n" +
                " <td align=\"center\" bgcolor=\"\" style=\"padding: 40px 0 30px 0;\">\n" +
                " \n" +
                "	 <img src=\"cid:"+promocion.getNoImagen()+"\">\n" +
                " \n" +
                "</td>\n" +
                " \n" +
                "</tr>\n" +
                "\n" +
                "\n" +
                " \n" +
                " </table>\n" +
                " \n" +
                "</body>\n" +
                " \n" +
                "</html>");
        LOGGER.debug("RUTA: "+rootFolderImage+promocion.getNoImagen());
        LOGGER.debug("noimagen: "+promocion.getNoImagen());
        LOGGER.debug("correos: "+correos);
        LOGGER.debug("titulo: "+promocion.getDeTitulo());
        
        File image = new File(rootFolderImage+promocion.getNoImagen());
        File imageLogo = new File(rootFolderImage+"logoPiombino.png");
        form.bodyPart(new FileDataBodyPart("inline", image,MediaType.APPLICATION_OCTET_STREAM_TYPE));
        form.bodyPart(new FileDataBodyPart("inline", imageLogo,MediaType.APPLICATION_OCTET_STREAM_TYPE));
        ClientResponse clientResponse = webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class, form);
        String output = clientResponse.getEntity(String.class);

        LOGGER.info("Email sent successfully : " + output);
        return true;
    }

}
