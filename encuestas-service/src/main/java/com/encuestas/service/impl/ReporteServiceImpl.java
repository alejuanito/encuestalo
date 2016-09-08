package com.encuestas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encuestas.data.repository.ReporteRepository;
import com.encuestas.service.ReporteService;
import com.encuestas.util.DateUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Service
public class ReporteServiceImpl implements ReporteService {
    private static final Logger LOGGER = LogManager.getLogger(ReporteServiceImpl.class);
    @Autowired
    private ReporteRepository reporteRepository;

    @Override
    public List<Map<String, Object>> reporteSatisfaccion(Integer idLocal, String feDesde, String feHasta,
            Integer idPregunta) throws ParseException{
        List<Map<String, Object>> data = new ArrayList<>();
        LOGGER.debug("Parametro de consulta, IdLocal "+idLocal);
        LOGGER.debug("feDesdel "+feDesde);
        LOGGER.debug("feHasta "+feHasta);
        LOGGER.debug("idPregunta "+idPregunta);
        
         Date dateIni=new Date(),dateFin= new Date();
        try {
                dateIni = new SimpleDateFormat("yyyy-MM-dd").parse(feDesde);
                dateFin = new SimpleDateFormat("yyyy-MM-dd").parse(feHasta);
                dateFin = DateUtils.sumarDias(dateFin, 1);
        } catch (ParseException e) {
                // TODO Auto-generated catch block
                LOGGER.error("Error: " + e.getMessage());
                e.printStackTrace();
        }
        
  
        List<Object[]> listReporte = reporteRepository.reporteSatisfaccion(idLocal, dateIni, dateFin, idPregunta);
        LOGGER.debug("Cantidad: "+ listReporte.size());
        String dePregunta = "", noLocal="";
        Integer total=0,muymalo=0,malo=0,regular=0,bueno=0,muybueno=0;
        Integer i=0;
        
        for(Object[] array : listReporte){
            Map<String, Object> obj = new HashMap<>();
            
            LOGGER.debug("dePregunta: "+ array[0]);
            LOGGER.debug("deRespuestaCorta: "+ array[1]);
            LOGGER.debug("cantidad: "+ array[2]);
            LOGGER.debug("local: "+ array[3]);
            
            if(!dePregunta.equals(array[0]) && i>0){
                LOGGER.debug("ENTRO AL IF EN LA ITERACION: "+i+1);
                obj.put("NU_PREGUNTA", i);
                obj.put("DE_PREGUNTA", dePregunta);
                obj.put("NO_LOCAL", noLocal);
                obj.put("TOTAL", total);
                obj.put("MUY_MALO", muymalo);
                obj.put("MALO", malo);
                obj.put("REGULAR", regular);
                obj.put("BUENO", bueno);
                obj.put("MUY_BUENO", muybueno);
                obj.put("FE_DESDE", feDesde);
                obj.put("FE_HASTA", feHasta);
                total=0;muymalo=0;malo=0;regular=0;bueno=0;muybueno=0;
                data.add(obj);
                
                total = total + Integer.parseInt(array[2].toString());
                LOGGER.debug("RESPUESTA: "+array[1].toString());
                switch(array[1].toString()){
                    case "MUY MALO" :
                       muymalo = muymalo + Integer.parseInt(array[2].toString());
                       break; //optional
                    case "MALO" :
                       malo = malo + Integer.parseInt(array[2].toString());
                       break; //optional
                    case "REGULAR" :
                       regular = regular + Integer.parseInt(array[2].toString());
                       break; //optional
                    case "BUENO" :
                       bueno = bueno + Integer.parseInt(array[2].toString());
                       break; //optional
                    case "MUY BUENO" :
                       muybueno = muybueno + Integer.parseInt(array[2].toString());
                       break; //optional
                    //You can have any number of case statements.
                    default : //Optional
                       //Statements
                }
            }else{
                LOGGER.debug("ENTRO AL ELSE EN LA ITERACION: "+i+1);
                total = total + Integer.parseInt(array[2].toString());
                LOGGER.debug("RESPUESTA: "+array[1].toString());
                switch(array[1].toString()){
                    case "MUY MALO" :
                       muymalo = muymalo + Integer.parseInt(array[2].toString());
                       break; //optional
                    case "MALO" :
                       malo = malo + Integer.parseInt(array[2].toString());
                       break; //optional
                    case "REGULAR" :
                       regular = regular + Integer.parseInt(array[2].toString());
                       break; //optional
                    case "BUENO" :
                       bueno = bueno + Integer.parseInt(array[2].toString());
                       break; //optional
                    case "MUY BUENO" :
                       muybueno = muybueno + Integer.parseInt(array[2].toString());
                       break; //optional
                    //You can have any number of case statements.
                    default : //Optional
                       //Statements
                }
            }
            i++;
            dePregunta = array[0].toString();
            noLocal =array[3].toString();
            if(listReporte.size()==i){
                obj = new HashMap<>();
                obj.put("NU_PREGUNTA", i);
                obj.put("DE_PREGUNTA", dePregunta);
                obj.put("NO_LOCAL", noLocal);
                obj.put("TOTAL", total);
                obj.put("MUY_MALO", muymalo);
                obj.put("MALO", malo);
                obj.put("REGULAR", regular);
                obj.put("BUENO", bueno);
                obj.put("MUY_BUENO", muybueno);
                obj.put("FE_DESDE", feDesde);
                obj.put("FE_HASTA", feHasta);
                data.add(obj);
            }
            
        }

       
        return data;
    }

    

}
