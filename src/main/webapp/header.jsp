<%--
  Created by IntelliJ IDEA.
  User: Chauncy
  Date: 2019/3/9
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
