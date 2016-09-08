<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/login-styles.css" rel="stylesheet" />
<%-- <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type="text/css" media="all" /> --%>
<%-- <link href="${pageContext.request.contextPath}/resources/css/boot.css" rel="stylesheet" type="text/css" media="all" /> --%>

    <title>Encuestas | Ingresar al sistema</title>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="container-fluid" style="padding-right: 0px; padding-left: 0px;">
        <div class="row">
            <div id="header" class="col-sm-12">
<%--                 <img src="${pageContext.request.contextPath}/resources/img/mostacho.jpg" /> --%>
            </div>
        </div>
        <div class="row main-container-piombino">
            <div class="col-sm-12">
                <div class="row inner-container-piombino">
                    <div class="col-sm-12">
                        <div class="col-sm-offset-4 col-sm-4">
                        <img src="${pageContext.request.contextPath}/resources/img/logoPiombino01b.png" class="img-responsive" style="margin: 0 auto;" />
                        <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            Usuario o contraseña incorrectos.
                        </div>
                        </c:if>
                        <form name="login_form" action="${pageContext.request.contextPath}/login" method="post">
                            <div class="form-group">
                                            <label for="username">Usuario</label> <input
                                                type="text" name="username" id="username"
                                                class="form-control" style="text-transform: inherit;" />
                                        </div>
                                        <div class="form-group">
                                            <label for="password">Contraseña</label> <input
                                                type="password" name="password" id="password"
                                                class="form-control" style="text-transform: inherit;" />
                                        </div>
                            <div class="text-center">
                                <button name="goto" value="encuesta" class="btn-encuesta-piombino" type="submit">Encuesta</button>
                                <button name="goto" value="admin" class="btn-admin-piombino" type="submit">Admin</button>
                            </div>
                        </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
    	<div class="row">
    		<div class="col-sm-12 text-right" style="font-size: 0.8em;">Desarrollado con <span>❤</span> por <a href="http://horizonteti.com.pe" target="_blank">Horizonte TI</a> &amp; <a href="http://inkasdev.com.pe" target="_blank">Inkas Dev</a> &amp; E-BPConsulting</div>
    	</div>
    </div>
    
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script>
    $(function() {
    	$('#username').focus();
    });
    </script>
</body>
</html>