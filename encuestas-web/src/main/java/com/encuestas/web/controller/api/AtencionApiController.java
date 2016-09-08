/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encuestas.data.bean.AtencionBean;
import com.encuestas.service.AtencionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtencionApiController {

	@Autowired
	AtencionService atencionService;

	@RequestMapping(value = { "/api/atencion" }, method = RequestMethod.POST)
	@ResponseBody
	public AtencionBean createAtencion(@RequestBody AtencionBean atencion) {

		return atencionService.createAtencion(atencion);
	}
        
        @RequestMapping(value = "/api/atencion/{idAtencion}", method = RequestMethod.GET)
        public AtencionBean getAtencion(@PathVariable Integer idAtencion) {
            return atencionService.getAtencion(idAtencion);
        }


	

}
