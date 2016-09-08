/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.web.controller.api;

import com.encuestas.data.bean.LocalBean;
import com.encuestas.service.LocalService;
import com.encuestas.web.utils.ContentTypeEnum;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.encuestas.data.bean.ClienteBean;
import com.encuestas.service.ClienteService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import pe.com.horizonteti.util.commons.reporting.exceptions.ReportGenerationException;
import pe.com.horizonteti.util.commons.reporting.jasperreports.BeanDataListReportExporter;
import pe.com.horizonteti.util.commons.reporting.jasperreports.DataListReportExporter;
import pe.com.horizonteti.util.commons.reporting.jasperreports.MapDataListReposrtExporter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClienteApiController {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private LocalService localService;

    @RequestMapping(value = {"/api/cliente"}, method = RequestMethod.GET)
    public Page<ClienteBean> consultaCliente(@RequestParam(required = false) String apPersona,
                                             @RequestParam(required = false) String amPersona,
                                             @RequestParam(required = false) String noPersona,
                                             @RequestParam(required = false) String coTipoDocumento,
                                             @RequestParam(required = false) String nuDocumento,
                                             @RequestParam(required = false) Integer idLocal,
                                             @RequestParam(required = false) Integer edadMin,
                                             @RequestParam(required = false) Integer edadMax,
                                             @RequestParam(required = false) Boolean inPromocional,
                                             @RequestParam(required = false, defaultValue = "0") Integer page,
                                             @RequestParam(required = false, defaultValue = "30") Integer size) {
        return clienteService.consultaCliente(apPersona, amPersona, noPersona, coTipoDocumento, nuDocumento, idLocal, edadMin, edadMax, inPromocional, page, size);
    }

    @RequestMapping(value = {"/api/cliente"}, method = RequestMethod.POST)
    public ClienteBean createAtencion(@RequestBody ClienteBean cliente) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return clienteService.createCliente(cliente, user.getUsername());
    }

    @RequestMapping(value = "/api/cliente/{idCliente}", method = RequestMethod.PUT)
    public ClienteBean actualizar (@RequestBody ClienteBean clienteBean) {
        return clienteService.actualizar(clienteBean);
    }


    @RequestMapping(value = {"/api/cliente/export"}, method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportConsultaCliente(@RequestParam(required = false, defaultValue = "PDF") String type,
                                                        @RequestParam(required = false) String apPersona,
                                                        @RequestParam(required = false) String amPersona,
                                                        @RequestParam(required = false) String noPersona,
                                                        @RequestParam(required = false) String coTipoDocumento,
                                                        @RequestParam(required = false) String nuDocumento,
                                                        @RequestParam(required = false) Integer idLocal,
                                                        @RequestParam(required = false) Integer edadMin,
                                                        @RequestParam(required = false) Integer edadMax,
                                                        @RequestParam(required = false) Boolean inPromocional) throws ReportGenerationException {
        List<ClienteBean> clientes = clienteService.consultaCliente(apPersona, amPersona, noPersona, coTipoDocumento, nuDocumento, idLocal, edadMin, edadMax, inPromocional);
        LocalBean local = null;

        if (idLocal != null) {
            local = localService.consultaPorId(idLocal);
        }

        Map<String, String> params = new HashMap<>();
        params.put("apPersona", apPersona == null ? "-" : apPersona);
        params.put("amPersona", amPersona == null ? "-" : amPersona);
        params.put("noPersona", noPersona == null ? "-" : noPersona);
        params.put("nuDocumento", nuDocumento == null ? "-" : nuDocumento);
        params.put("noLocal", idLocal == null ? "-" : local.getNoLocal());
        params.put("edadMin", edadMin == null ? "-" : edadMin+"");
        params.put("edadMax", edadMax == null ? "-" : edadMax+"");
        params.put("promociones", inPromocional == null ? "-" : (inPromocional ? "Sí" : "No"));
        params.put("logo_ruta", "logoPiombino01b.png");

        DataListReportExporter<ClienteBean> exporter = new BeanDataListReportExporter<>(clientes, "reports/clientes.jrxml", params);

        ContentTypeEnum cType = ContentTypeEnum.valueOf(type);
        byte[] bytes;

        if (cType.equals(ContentTypeEnum.PDF)) {
            bytes = exporter.getPdfBytes();
        } else {
            SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
            config.setOnePagePerSheet(false);
            config.setIgnoreCellBackground(false);
            config.setWrapText(true);
            config.setRemoveEmptySpaceBetweenRows(true);
            config.setCollapseRowSpan(true);
            config.setWhitePageBackground(false);
            bytes = exporter.getExcelBytes(config);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(cType.getCode()));
        String filename = "directorioClientes-" + (new Date().getTime()) + cType.getExt();
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");


        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}
