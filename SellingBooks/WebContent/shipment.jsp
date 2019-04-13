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
<title>Giao hàng 24h</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <jsp:include page="category.jsp"></jsp:include>
            </div>
            <div class="col-sm-9">

                <div class="row">
                    <div class="col-sm-12">
                        <div style="color: black;">
                             <h2 align="center" class="tieude">Thời gian và phương thức vận chuyển</h2>
                            <ul>
                                <li><strong>Đối với khách hàng ở nội thành Tp.HCM:</strong>
                                    Nhân viên Minh Khai sẽ liên hệ và giao sách cho Quý khách trong
                                    vòng 24h tính từ lúc Quý khách nhận được email xác nhận đơn hàng
                                    của Minh Khai..</li>
                                <li><strong>Đối với khách hàng ở ngoại thành Tp.HCM /
                                        Tỉnh:</strong> Minh Khai sẽ tiếnhành gửi sách cho Quý khách qua đường
                                    Bưu điện trong vòng 24h kể từ lúc Minh Khai nhận đủ số tiền
                                    chuyển khoản của Quý khách. Quý khách sẽ nhận được sách sau 7 –
                                    10 ngày (gửi thường) hoặc 2 – 3 ngày (gửi nhanh).</li>
                                <li><strong>Đối với khách hàng ở Nước ngoài:</strong> Minh Khai
                                    sẽ gửi sách qua đường Bưu điện (theo đường Biển hoặc qua đường
                                    Máy bay - tùy theo hình thức vận chuyển khách hàng chọn).</li>
                            </ul>
                            <br />
                            <p style="text-align: center;"><strong> Mọi thắc mắc xin liên hệ theo địa chỉ:</strong> </p>
                            
                            <ul>
                                <li><strong>Công ty TNHH Minh Khai S.G</strong></li>
                                <li><strong>249 - Nguyễn Thị MinhKhai, phường Nguyễn Cư Trinh, Quận 1 </strong></li>
                                <li><strong>TP. Hồ Chí Minh - ViệtNam </strong></li>
                                 <li><strong>Tel: 08 39 250 590 – 08 39 250 591 </strong></li> 
                                 <li><strong>Website:<a href="http://www.minhkhai.vn">www.minhkhai.vn</a> và 
                                 <a href="http://www.minhkhai.com.vn">www.minhkhai.com.vn</a></strong></li> 
                                <li><strong>E-mail:mk.book@minhkhai.com.vn</strong></li>
                                </ul>
                        </div>

                    </div>
                </div>

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