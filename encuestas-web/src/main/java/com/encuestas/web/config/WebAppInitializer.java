package com.encuestas.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by JaxKodex on 25/10/2015.
 */
public class WebAppInitializer {// implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//
//        // Manage the lifecycle of the root application context
//        servletContext.addListener(new ContextLoaderListener(rootContext));
//        
//        // Create the dispatcher servlet's Spring application context
//        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
//        dispatcherServlet.register(SpringMvcConfig.class);
//
////        servletContext.setInitParameter("log4jConfiguration", "log4j.properties");
//        
//        // Register and map the dispatcher servlet
//        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//        
////        FilterRegistration.Dynamic securityFilter = servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
////        securityFilter.addMappingForUrlPatterns(null, false, "/*");
//    }
}
