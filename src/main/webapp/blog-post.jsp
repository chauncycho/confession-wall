<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Blog Post - Brand</title>
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
<%@include file="header.jsp" %>
<main class="page blog-post" style="padding: 46px 0 0;">
    <section class="clean-block clean-post dark" style="padding: 20px 0;">
        <div class="container">
            <div class="block-content">
                <div class="post-image" style="background-image:url(images/slider2.jpg);"></div>
                <div class="post-body" style="padding: 40px;">
                    <div class="container">
                        <h3>Title</h3>
                        <div class="post-info"><span>By Chauncy Cho</span><span>Mar 11, 2019</span></div>
                        <%--<c:set var="dataList" value="${CWallData}" scope="request"/>--%>
                        <% int i = 1;%>
                        <c:forEach items="${CWallData}" var="data">
                            <%-- 编号 --%>
                            <p style="text-align: center">
                                <span style="font-family: 宋体">
                                    <span style="font-size: 15px"><%=i++%></span>
                                </span>
                            </p>

                            <%-- 内容 --%>
                            <p style="text-align: center">
                                <span style="font-family: 宋体">
                                    <span style="font-size: 15px">${data.getContent()}</span>
                                </span>
                            </p>

                            <%-- 联系方式 --%>
                            <c:if test="${ShowContact == true}">
                                <p style="text-align: center">
                                    <span style="font-family: 宋体">
                                        <span style="font-size: 15px">${data.getContact()}</span>
                                    </span>
                                </p>
                            </c:if>

                            <%-- 日期 --%>
                            <p style="text-align: ${DataPosition}">
                                <span style="font-family: Arial">
                                    <span style="font-size: 14px">${data.getEnd_time()}</span>
                                </span>
                            </p>
                            <p style="text-align: center">&nbsp;</p>
                            <p style="text-align: center">&nbsp;</p>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<footer class="page-footer dark">
    <div class="footer-copyright">
        <p>Copyright © 2019 ChauncyCho. All rights reserved.</p>
    </div>
</footer>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
<script src="assets/js/smoothproducts.min.js"></script>
<script src="assets/js/theme.js"></script>
<script src="assets/js/bs-animation.js"></script>
</body>

</html>