package com.encuestas.web.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
  private static final Logger LOGGER = LogManager.getLogger(LoginSuccessHandler.class);

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
    String goTo = (String) request.getParameter("goto");

    if ("admin".equals(goTo)) {
      response.sendRedirect(request.getContextPath()+"/admin");
      return;
    }
    response.sendRedirect(request.getContextPath()+"/");
  }

}
