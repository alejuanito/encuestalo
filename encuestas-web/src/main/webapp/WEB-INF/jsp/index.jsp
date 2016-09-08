<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page session="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Sistema de Encuestas</title>
    <link href="${pageContext.request.contextPath}/resources/css/spinkit.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/resources/css/login-styles.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/loading.css" rel="stylesheet">
    
<script type="text/javascript">
	var baseUrl = '${pageContext.request.contextPath}/api/admin';
	var rootUrl = '${pageContext.request.contextPath}';
	var userData = ${userData};	 
</script>
</head>
<body>
 <div class="admin-modal"></div>
  <div class="container" style="background: transparent;" id="loading-placeholder">

  </div>
 
  <div class="loading-holder">
    <div class="loading-message">
        <img src="${pageContext.request.contextPath}/resources/img/logoPiombino01b.png" class="img-responsive" style="margin: 0 auto; height: 100px;" />
        Cargando
        <div class="sk-wave">
        <div class="sk-rect sk-rect1"></div>
        <div class="sk-rect sk-rect2"></div>
        <div class="sk-rect sk-rect3"></div>
        <div class="sk-rect sk-rect4"></div>
        <div class="sk-rect sk-rect5"></div>
      </div>
    </div>
  </div>
    <div class="container-fluid">
        <div class="row">
            <div id="header" class="col-sm-12" style="absolute: relative;">
<%--                 <img class="img-responsive" src="${pageContext.request.contextPath}/resources/img/mostacho.jpg" /> --%>
                <div class="user-data-container">
                    <div id="usuario" class="user-data">
                        <span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;
                    <span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out">Salir</span></a></div>
                    <div id="fecha" class="user-data"></div>
                    
                    </div>
                </div>
            </div>
        </div>
        <div class="row main-container-piombino">
            <div class="col-sm-12">
                <div class="row inner-container-piombino">
                    <div class="col-sm-12">
                        <div id="admin-main">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <!-- /div -->
    <div class="container">
    	<div class="row">
    		<div class="col-sm-12 text-right" style="font-size: 0.8em;">Desarrollado con <span>❤</span> por <a href="http://horizonteti.com.pe" target="_blank">Horizonte TI</a> &amp; <a href="http://inkasdev.com.pe" target="_blank">Inkas Dev</a> &amp; E-BPConsulting</div>
    	</div>
    </div>
 
 <script data-main="${pageContext.request.contextPath}/resources/js/app/admin-config.js" src="${pageContext.request.contextPath}/resources/js/require.js"></script>
</body>
</html>