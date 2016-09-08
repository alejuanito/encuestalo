/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;


public class DateUtils {
    private static final Logger LOGGER = Logger.getLogger(DateUtils.class);
    public static final String DATE_ONLY_FORMAT = "dd/MM/yyyy";
    public static final String DATE_TIME_AMPM_FORMAT = "dd/MM/yyyy hh:mm a";
    public static final long MILLISECONDS_TO_HOURS_FACTOR = 60 * 60 * 1000;
    public static final long MILLISECONDS_TO_MINUTES_FACTOR = 60 * 1000;

    private DateUtils() {
    }

    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String formatToDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_AMPM_FORMAT);
        return sdf.format(date);
    }

    public static Date parseToDateTimeAmPm(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_AMPM_FORMAT);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException ex) {
            LOGGER.error("Error parseando date " + date, ex);
        }
        return date;
    }
    
    public static Date parseToDateTimeAmPm(Date date, String horaMinuto, String amPm) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_AMPM_FORMAT);
        Date dateReturn = null;
        try {
            dateReturn = sdf.parse(formatToDateOnly(date).concat(" ").concat(horaMinuto).concat(" ").concat(amPm));
        } catch (ParseException ex) {
            LOGGER.error("Error parseando date " + date, ex);
        }
        return dateReturn;
    }

    public static String formatToDateOnly(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_ONLY_FORMAT);
        return sdf.format(date);
    }
    
    public static String formatToDateOnlyByFormat(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date removeTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_ONLY_FORMAT);
        try {
            return sdf.parse(sdf.format(date));
        } catch (ParseException ex) {
            LOGGER.error("Error al quitar el tiempo de al fecha " + date, ex);
        }
        return date;
    }

    public static boolean esSabado(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return Calendar.SATURDAY == calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * Suma las horas a una fecha determinada.
     * @param date fecha/hora a la que se restarán las horas
     * @param numHoras de horas que se agregarán (positivo) restarán (negativo)
     * @return nueva fecha modificada
     */
    public static Date sumarHoras(Date date, int numHoras) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.HOUR, numHoras);

        return calendar.getTime();
    }
    
    public static Date sumarMinutos(Date date, int numMinutos) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.MINUTE, numMinutos);

        return calendar.getTime();
    }

    public static Date sumarDias(Date date, int numDias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.DATE, numDias);

        return calendar.getTime();
    }

    public static List<Date> obtenerListaFechas(Date desde, Date hasta) {
        List<Date> dateList = new ArrayList<Date>();

        Calendar calendar = Calendar.getInstance();
        Date date = new Date(desde.getTime());
        while (date.compareTo(hasta) < 1) {
            dateList.add(date);
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 1);
            date = calendar.getTime();
        }

        return dateList;
    }
    
    
    public static Boolean isMismoMes(Date feEmision){
        Calendar calFeEmision = Calendar.getInstance();
        Calendar calFeActual = Calendar.getInstance();       
        calFeEmision.setTime(feEmision);        
        return (calFeEmision.get(Calendar.MONTH) == calFeActual.get(Calendar.MONTH));
    }
    
    public static String getDeAmPM (Date fecha) {
        return new SimpleDateFormat("aa").format(fecha);
    }
    
    public static String getAmPmTimeString (Date fecha) {
        return new SimpleDateFormat("hh:mm").format(fecha);
    }
    
    public static Date getLastTimeOfDay(Date fecha) {
        Calendar cFecha = Calendar.getInstance();
        cFecha.setTime(removeTime(fecha));
        cFecha.add(Calendar.DAY_OF_MONTH, 1);
        cFecha.add(Calendar.SECOND, -1);
        
        return cFecha.getTime();
    }
    
    public static boolean isDateEqual(Date feUno, Date feDos) {
        feUno = removeTime(feUno);
        feDos = removeTime(feDos);
        
        if(feUno.compareTo(feDos) == 0) {
            return true;
        }
        
        return false;
    }
}
