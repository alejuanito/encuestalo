/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.web.jobs;
import com.encuestas.service.PromocionService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.apache.log4j.Logger;
/**
 *
 * @author Alejandro
 */
public class EnvioPromocionesJobs implements Job{
    
    private static final Logger LOGGER = Logger.getLogger(EnvioPromocionesJobs.class);
    @Autowired
    private PromocionService promocionService;

    public EnvioPromocionesJobs() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        LOGGER.trace("Enviando promociones ...");
        promocionService.enviarPromociones();
    }
}
