package com.encuestas.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.encuestas.service.RespuestaEncuestaReporteService;
import com.encuestas.web.utils.ContentTypeEnum;

import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import pe.com.horizonteti.util.commons.reporting.exceptions.ReportGenerationException;
import pe.com.horizonteti.util.commons.reporting.jasperreports.DataListReportExporter;
import pe.com.horizonteti.util.commons.reporting.jasperreports.MapDataListReposrtExporter;

@Controller
public class ReportController {
  @Autowired
  private RespuestaEncuestaReporteService respuestaEncuestaReporteService;


  @RequestMapping(value = "/reports/export/reportReporteEncuestaResultados",
      method = RequestMethod.GET)
  public ResponseEntity<byte[]> reportReporteEncuestaResultados(@RequestParam Integer idEncuesta,
      @RequestParam(required=false) String coTipoPregunta, @RequestParam Date desde, @RequestParam Date hasta,
      @RequestParam(required = false, defaultValue = "PDF") String type)
          throws ReportGenerationException {

    List<Map<String, ?>> data = respuestaEncuestaReporteService.consultaResultados(idEncuesta, coTipoPregunta, desde, hasta);

    Map<String, String> params = new HashMap<>();

    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    
    params.put("logo_ruta", "logoPiombino01b.png");
    params.put("titulo", String.format("Encuestas realizadas desde %s hasta %s con pregunta %s", dateFormatter.format(desde), 
        dateFormatter.format(hasta), "ABIE".equals(coTipoPregunta) ? "ABIERTA" : ("CERR".equals(coTipoPregunta) ? "CORTA" : "TODAS")));
    DataListReportExporter<?> exporter = new MapDataListReposrtExporter(data,
        "reports/reportReporteEncuestaResultados.jrxml", params);

    ContentTypeEnum cType = ContentTypeEnum.valueOf(type);

    byte[] bytes;
    
    if (cType.equals(ContentTypeEnum.PDF)) {
      bytes = exporter.getPdfBytes();
    } else {
      SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
      config.setOnePagePerSheet(false);
//      config.setDetectCellType(true);
      config.setIgnoreCellBackground(false);
      config.setWrapText(true);
      config.setRemoveEmptySpaceBetweenRows(true);
      config.setCollapseRowSpan(true);
      config.setWhitePageBackground(false);
      bytes = exporter.getExcelBytes(config);
    }

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType(cType.getCode()));
    String filename = "reportReporteEncuestaResultados-" + (new Date().getTime()) + cType.getExt();
    headers.setContentDispositionFormData(filename, filename);
    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");


    return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
  }

  @InitBinder
  protected void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
  }
}
