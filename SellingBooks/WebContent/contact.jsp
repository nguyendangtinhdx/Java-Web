<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<title>Liên hệ</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <jsp:include page="category.jsp"></jsp:include>
            </div>
            <div class="col-sm-9">
                <div id="contact-page">

                    <div class="row">
                        <div class="col-sm-12">
                            <div class="contact-form">
                                <h2 class="title text-center">Thông tin liên hệ</h2>
                                <div class="status alert alert-success" style="display: none"></div>
                                <form id="main-contact-form" class="contact-form row"
                                    name="contact-form" method="post">
                                    <div class="form-group col-md-6">
                                        <input type="text" name="name" class="form-control"
                                            required="required" placeholder="Họ tên">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <input type="email" name="email" class="form-control"
                                            required="required" placeholder="Email">
                                    </div>
                                    <div class="form-group col-md-12">
                                        <input type="text" name="address" class="form-control"
                                            required="required" placeholder="Địa chỉ">
                                    </div>
                                    <div class="form-group col-md-12">
                                        <input type="text" name="phone" class="form-control"
                                            required="required" placeholder="Số điện thoại">
                                    </div>
                                    <div class="form-group col-md-12">
                                        <textarea name="message" id="message" required="required"
                                            class="form-control" rows="8" placeholder="Nội dung "></textarea>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <input type="submit" name="submit"
                                            class="btn btn-primary pull-right" value="Gửi yêu cầu">
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>
                    <div class="col-sm-12">
                        <div class="contact-info">
                            <h2 class="title text-center">Địa chỉ liên hệ</h2>
                            <address>
                                <p>SellingBooks Inc.</p>
                                <p>935 W. Webster Ave New Streets Chicago, IL 60614, NY</p>
                                <p>Newyork USA</p>
                                <p>Mobile: +2346 17 38 93</p>
                                <p>Fax: 1-714-252-0026</p>
                                <p>Email: info@e-shopper.com</p>
                            </address>
                            <div class="social-networks">
                                <h2 class="title text-center">Liên hệ qua Internet</h2>
                                <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                    <li><a href="#"><i class="fa fa-youtube"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!--/#contact-page-->
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</html>