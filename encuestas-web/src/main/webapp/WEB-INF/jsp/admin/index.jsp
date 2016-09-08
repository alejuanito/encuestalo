<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Administración | Encuestas</title>

    <link href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/spinkit.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/simple-sidebar.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/common-styles.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/loading.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
        var rootUrl = '${pageContext.request.contextPath}';
        var tipoDocumentoData = ${tipoDocumentoData};
        var usuarioData = ${usuarioData};
    </script>
</head>
<body>

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

    <div id="wrapper">
        <div id="sidebar-wrapper">
            <div id="menu"></div>
        </div>
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div id="top" class="row">

                </div>
                <div class="row">
                    <div id="content" class="col-lg-12"></div>
                </div>
                </div>
            </div>
    </div>
<%--
<div id="main" class="container-fluid">
    <div class="clearfix" style="position: absolute; width: 100%;">
        <div id="user-info" class="clearfix pull-right">
            <div class="pull-left" id="user-image-holder">
                <img class="img-responsive" src="${pageContext.request.contextPath}/resources/img/bueno.png"/>
            </div>
            <div class="pull-left" id="user-data"><span>Administrador</span> <br /><a href="${pageContext.request.contextPath}/logout">Salir</a></div>
        </div>
    </div>
    <div id="content"></div>
</div>
<div class="menu-overlay"></div>
<div id="menu"></div>
--%>

<script data-main="${pageContext.request.contextPath}/resources/js/admin/config.js"
        src="${pageContext.request.contextPath}/resources/js/require.js"></script>
<%-- <script data-main="${pageContext.request.contextPath}/resources/js/admin.min.js" --%>
<%--         src="${pageContext.request.contextPath}/resources/js/require.js"></script> --%>
</body>
</html>
