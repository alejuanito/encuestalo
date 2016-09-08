package com.encuestas.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.encuestas.data.bean.RolBean;
import com.encuestas.service.RolService;
import com.encuestas.service.exception.DataValidationErrorException;

@RestController
public class RolApiController {
    @Autowired
    private RolService rolService;

    @RequestMapping(value="/api/rol", method=RequestMethod.GET)
    public List<RolBean> listar () {
        return rolService.listAll();
    }
    
    @RequestMapping(value="/api/rol/{idRol}", method=RequestMethod.GET)
    public RolBean load (@PathVariable Integer idRol) {
        return rolService.load(idRol);
    }
    
    @RequestMapping(value="/api/rol", method=RequestMethod.POST)
    public RolBean crear (@RequestBody RolBean rolBean) throws DataValidationErrorException {
        return rolService.create(rolBean);
    }
    
    @RequestMapping(value="/api/rol/{idRol}", method=RequestMethod.PUT)
    public RolBean actualizar (@RequestBody RolBean rolBean) throws DataValidationErrorException {
        return rolService.update(rolBean);
    }
    
    @ExceptionHandler({DataValidationErrorException.class})
    @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
    public Map<String, Object> onDataValidationException (DataValidationErrorException dataValidationErrorException) {
        Map<String, Object> response = new HashMap<>();
        response.put("errors", dataValidationErrorException.getErrors());
        return response;
    }
}
