<%--
  Created by IntelliJ IDEA.
  User: Chauncy
  Date: 2019/3/9
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Login - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Averia+Gruesa+Libre">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Averia+Libre">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Averia+Sans+Libre">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Averia+Serif+Libre">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/Navbar-Fixed-Side.css">
    <link rel="stylesheet" href="assets/css/Simple-Vertical-Navigation-Menu-v-10.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top clean-navbar" style="background-color: #fee8fd;padding: 0 16px;">
    <div class="container"><a class="navbar-brand logo" href="#" style="font-family: Montserrat, sans-serif;color: #e663e0;">北信科表白墙</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div
                class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link border rounded" href="index.jsp" style="background-color: #fee8fd;color: #e663e0;">首页</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link border rounded" href="blog-post-list.jsp" style="background-color: #fee8fd;color: #e663e0;">表白墙</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link border rounded" href="about-us.jsp" style="background-color: #fee8fd;color: #e663e0;">关于</a></li>

                <c:if test="${loginState == 1}">
                    <li class="nav-item" role="presentation"><a class="nav-link border rounded" href="background.jsp" style="background-color: #fee8fd;color: #e663e0;">管理中心</a></li>

                </c:if>
                <c:set var="loginState" value="${loginState}" scope="session"/>
                <c:if test="${loginState == 0}">
                    <li class="nav-item" role="presentation"><a class="nav-link border rounded active" href="login.jsp" style="background-color: #fee8fd;color: #e663e0;">登录</a></li>
                </c:if>
                <c:if test="${loginState == 1}">
                    <li class="nav-item" role="presentation"><a class="nav-link border rounded active" href="logout" style="background-color: #fee8fd;color: #e663e0;">登出</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
<script src="assets/js/smoothproducts.min.js"></script>
<script src="assets/js/theme.js"></script>
<script src="assets/js/bs-animation.js"></script>
</body>

</html>
