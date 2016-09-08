/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.web.controller.api;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.encuestas.data.bean.PromocionBean;
import com.encuestas.service.MailService;
import com.encuestas.service.PromocionService;
import com.encuestas.service.exception.DataValidationErrorException;
import com.encuestas.web.exception.UploadException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PromocionApiController {

    @Value("${email.root.folderImage}")
    private String rootFolderImage;
    private ServletContext servletContext;
    private final Logger LOGGER = Logger.getLogger(PromocionApiController.class);
    @Autowired
    private PromocionService promocionService;
    @Autowired
    private MailService mailService;
//    @Autowired
//    FileValidator fileValidator;

    @RequestMapping(value = {"/api/promocion"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PromocionBean> listPromocion() {
         User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return promocionService.listPromocion(user.getUsername());
    }

    @RequestMapping(value = {"/api/promocion/testMail"}, method = RequestMethod.GET)
    @ResponseBody
    public Boolean enviarPromocion() {
        return mailService.enviarPromociones();
    }

    @RequestMapping(value = {"/api/promocion/testMailAdjunto"}, method = RequestMethod.GET)
    @ResponseBody
    public Boolean enviarPromocionAdjunto() {
        //return mailService.enviarPromocionesAdjunto();
        return promocionService.enviarPromociones();
    }

    @RequestMapping(value = {"/api/promocion/{idPromocion}"}, method = RequestMethod.GET)
    @ResponseBody
    public PromocionBean load(@PathVariable Integer idPromocion) {
        return promocionService.load(idPromocion);
    }

    @RequestMapping(value = "/api/promocion/image", method = RequestMethod.POST)
    @ResponseBody
    public Boolean guardarImagen(@RequestParam(value = "image") MultipartFile image) throws UploadException {
        LOGGER.debug("Guardando imagen: " + image.isEmpty());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
         InputStream inputStream = null;  
         //OutputStream outputStream = null;  
  
        if (!image.isEmpty()) {
            validateImage(image);
            LOGGER.debug("Imgen validada");
            String fileName = image.getOriginalFilename();  
            try {
                inputStream = image.getInputStream();
                String noFile = rootFolderImage + fileName;
               
                return promocionService.saveImage(noFile, inputStream, user.getUsername());

            } catch (IOException | RuntimeException e) {
                LOGGER.error("Error al crear imagen: "+ e.getMessage());
                throw new UploadException("Error al crear archivo: " + e.getMessage());   
               
            }
        }
        return true;
    }

    @RequestMapping(value = "/api/promocion", method = RequestMethod.POST)
    @ResponseBody
    public PromocionBean guardar(@RequestBody PromocionBean promocionBean) {
         User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         LOGGER.debug(promocionBean.getFeInicio());
        return promocionService.create(promocionBean, user.getUsername());
    }

    @RequestMapping(value = "/api/promocion/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public PromocionBean actualizar(@RequestBody PromocionBean promocionBean) {
         User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return promocionService.update(promocionBean, user.getUsername());
    }
    @RequestMapping(value = "/api/promocion/desactivar/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public PromocionBean desactivar(@PathVariable Integer id) {
        return promocionService.desactivar(id);
    }

    @ExceptionHandler({DataValidationErrorException.class})
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public Map<String, Object> onDataValidationException(DataValidationErrorException dataValidationErrorException
    ) {
        Map<String, Object> response = new HashMap<>();
        response.put("errors", dataValidationErrorException.getErrors());
        return response;
    }

    private void validateImage(MultipartFile image) {
        if (!image.getContentType().equals("image/jpeg") && !image.getContentType().equals("image/png")) {
            throw new RuntimeException("Solo se aceptan imagenes jpg y png");
        }
    }

//    private FileOutputStream convertFile(MultipartFile image) {
//        File convFile = new File("E:\\" + image.getOriginalFilename());
//        try {
//            convFile.createNewFile();
//            FileOutputStream fos = new FileOutputStream(convFile);
//            return fos;
//        } catch (Exception ex) {
//            throw new RuntimeException("Error: " + ex.getMessage());
//        }
////            catch (FileNotFoundException ex) {
////                throw new RuntimeException("Archivo no encontrado");            
////            }
////            try {                
////                FileOutputStream fos = new FileOutputStream(convFile);
////                return fos;
////            } catch (FileNotFoundException ex) {
////                throw new RuntimeException("Archivo no encontrado");            
////            }
//    }


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
