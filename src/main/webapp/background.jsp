<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Shopping Cart - Brand</title>
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
<section style="margin: 46px 0 0 0;">
    <div class="container">
        <div class="row">
            <div class="col-lg-3" style="height: auto;">
                <nav class="navbar navbar-light navbar-expand-lg d-xl-flex">
                    <div class="container-fluid">
                        <button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-2"><span
                                class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse text-left d-lg-flex justify-content-lg-center"
                             id="navcol-2">
                            <ul class="nav navbar-nav">
                                <li class="nav-item" role="presentation" style="width: 100%;"><a
                                        class="nav-link active text-center" href="#">格式转换</a></li>
                                <li class="nav-item" role="presentation" style="width: 100%;"><a
                                        class="nav-link text-center" href="#">数据分析</a></li>
                                <li class="nav-item" role="presentation" style="width: 100%;"><a
                                        class="nav-link text-center" href="#">反馈信息</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="col">
                <form action="upload" method="post" enctype="multipart/form-data">
                    <div style="margin: 10px 0;">
                        <label style="margin: 0 20px;width: 150px;">格式选择</label>
                        <select name="type" class="form-control d-inline-block" style="width: auto;">
                            <optgroup label="选择格式">
                                <option value="excel" selected="">Excel</option>
                                <option value="csv">CSV</option>
                            </optgroup>
                        </select>
                    </div>
                    <div
                            style="margin: 10px 0;"><label style="margin: 0 20px;width: 150px;">日期位置</label><select
                            class="form-control d-inline-block" name="datePosition" style="width: auto;">
                        <optgroup label="日期位置">
                            <option value="right" selected="">居右</option>
                            <option value="center">居中</option>
                            <option value="left">居左</option>
                        </optgroup>
                    </select></div>
                    <div
                            style="margin: 10px 0;"><label style="margin: 0 20px;width: 150px;">是否显示联系方式</label>
                        <div class="form-check d-inline" style="width: auto;margin: 0 20px 0 0;"><input
                                class="form-check-input" type="radio" name="showContract" value="yes" checked=""
                                id="formCheck-1"><label class="form-check-label" for="formCheck-1">Yes</label></div>
                        <div class="form-check d-inline" style="width: auto;"><input class="form-check-input"
                                                                                     type="radio" name="showContract"
                                                                                     value="no" id="formCheck-1"><label
                                class="form-check-label" for="formCheck-1">No</label></div>
                    </div>
                    <div style="margin: 10px 0;"><label style="margin: 0 20px;width: 150px;">是否包含表头</label>
                        <div class="form-check d-inline" style="width: auto;margin: 0 20px 0 0;"><input
                                class="form-check-input" type="radio" name="hasHead" value="yes" checked=""
                                id="formCheck-1"><label class="form-check-label" for="formCheck-1">Yes</label></div>
                        <div class="form-check d-inline" style="width: auto;"><input class="form-check-input"
                                                                                     type="radio" name="hasHead"
                                                                                     value="no" id="formCheck-1"><label
                                class="form-check-label" for="formCheck-1">No</label></div>
                    </div>
                    <div style="margin: 10px 0;"><label style="margin: 0 20px;width: 150px;">文件上传</label><input name="file"
                            type="file"></div>
                    <div style="margin: 10px 0;">
                        <button class="btn btn-primary" type="submit" style="margin: 0 20px;width: 72px;">提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<main class="page shopping-cart-page" style="padding: 46px 0 0;"></main>
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