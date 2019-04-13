<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet">
<title>Slider</title>
</head>
<body>

    <!--slider-->
    <div id="slider-carousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
            <li data-target="#slider-carousel" data-slide-to="1"></li>
            <li data-target="#slider-carousel" data-slide-to="2"></li>
            <li data-target="#slider-carousel" data-slide-to="3"></li>
            <li data-target="#slider-carousel" data-slide-to="4"></li>
        </ol>

        <div class="carousel-inner">
            <div class="item active">
                <div class="col-sm-12">
                <a href="#">
                    <img src="image/slide/1.jpg" class="girl img-responsive margin_left_slide" alt="" width="100%" height="300px" /> <img
                        src="images/home/pricing.png" class="pricing" alt="" />
                </a>
                </div>
            </div>
            <div class="item">
                <div class="col-sm-12">
                 <a href="#">
                    <img src="image/slide/2.jpg" class="girl img-responsive margin_left_slide" alt="" width="100%" height="300px" /> <img
                        src="images/home/pricing.png" class="pricing" alt="" />
                </a>
                </div>
            </div>

            <div class="item">
                <div class="col-sm-12">
                 <a href="#">
                    <img src="image/slide/3.png" class="girl img-responsive margin_left_slide" alt="" width="100%" height="300px" /> <img
                        src="images/home/pricing.png" class="pricing" alt="" />
                </a>
                </div>
            </div>
            
            <div class="item">
                <div class="col-sm-12">
                 <a href="#">
                    <img src="image/slide/4.jpg" class="girl img-responsive margin_left_slide" alt="" width="100%" height="300px" /> <img
                        src="images/home/pricing.png" class="pricing" alt="" />
                </a>
                </div>
            </div>
            
            <div class="item">
                <div class="col-sm-12">
                 <a href="#">
                    <img src="image/slide/5.jpg" class="girl img-responsive margin_left_slide" alt="" width="100%" height="300px" /> <img
                        src="images/home/pricing.png" class="pricing" alt="" />
                </a>
                </div>
            </div>

        </div>

        <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev"> <i
            class="fa fa-angle-left"></i>
        </a> <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
            <i class="fa fa-angle-right"></i>
        </a>
    </div>

    <!--/slider-->

</body>
</html>
