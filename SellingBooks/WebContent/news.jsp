<%@page import="java.text.NumberFormat"%>
<%@page import="Bean.SachBean"%>
<%@page import="Dao.SachDao"%>
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
<title>Bản tin</title>
</head>
<body>

    <jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <jsp:include page="category.jsp"></jsp:include>
            </div>
            <div class="col-sm-9">
                <div class="col-sm-12">
                    <h2 align="center" class="tieude">Thể lệ chương trình tích lũy điểm</h2>
                    <br>
                    <div>
                        <ol>
                            <li><span style="color: #800000;">Đối tượng tham gia:</span> khách
                                đến mua hàng trực tiếp tại nhà sách Minh Khai.</li>
                            <li><span style="color: #800000;">Cách tham gia:</span><br> ·
                                Khi mua hàng, khách tích điểm qua số điện thoại hoặc thẻ thành viên
                                nếu<br> có.<br> · Thẻ thành viên được cấp cho khách ở lần
                                đầu tiên khách nhận tiền chiết<br> khấu.</li>
                            <li><span style="color: #800000;">Quy tắc tích điểm:</span><br>
                                · Mỗi 200,000VND trong hóa đơn mua hàng được quy đổi thành 1 điểm<br>
                                · Số tiền còn thừa không thể quy đổi thành điểm của hóa đơn sẽ được
                                cộng<br> dồn cho lần mua hàng tiếp theo.</li>
                            <li><span style="color: #800000;">Nhận tiền chiết khấu:</span><br>
                                · Khách có thể dùng 5 điểm đã tích lũy từ các lần mua hàng trước đó
                                để đổi<br> lấy tiền chiết khấu trên giá trị của hóa đơn mua
                                hàng hiện tại.<br> · Trong vòng 60 phút kể từ lần đổi điểm lấy
                                tiền chiết khấu gần nhất, nếu<br> khách tiếp tục mua hàng thì
                                các hóa đơn được thanh toán trong thời hạn<br> này sẽ được tiếp
                                tục nhận tiền chiết khấu mà không phải mất thêm điểm.<br> Lưu
                                ý: số tiền chiết khấu khách nhận được sẽ được trừ vào số tiền dùng
                                để<br> tích lũy điểm của hóa đơn tương ứng.</li>
                            <li><span style="color: #800000;">Các mức chiết khấu:</span><br>
                                · Mức bạc: 10% trên giá trị hóa đơn.<br> · Mức vàng: 15% trên
                                giá trị hóa đơn.<br> · Mức kim cương: 20% trên giá trị hóa đơn.<br>
                                <strong>Lưu ý:</strong> các mặt hàng đang nằm trong các chương trình
                                khuyến mãi, giảm giá<br> không được tham gia tính chiết khấu.</li>
                            <li><span style="color: #800000;">Cách xác định mức chiết
                                    khấu:</span><br> · Mức bạc: doanh số mua hàng trong chu kỳ tích
                                lũy dưới 20 triệu.<br> · Mức vàng: doanh số mua hàng trong chu
                                kỳ tích lũy từ 20 triệu đến dưới 30<br> triệu. Khách được hưởng
                                mức chiết khấu này trong 365 ngày kể từ ngày đạt<br> mức.<br>
                                · Mức kim cương: doanh số mua hàng trong chu kỳ tích lũy từ 30 triệu
                                trở<br> lên. Khách được hưởng mức chiết khấu này trong 365 ngày
                                kể từ ngày đạt<br> mức.<br> Chu kỳ tích lũy là khoảng thời
                                gian mỗi 365 ngày tính từ ngày đầu tiên khách<br> tham gia
                                chương trình. Khi sang chu kỳ mới, điểm và doanh số của chu kỳ cũ<br>
                                sẽ bị hủy, trở về mức 0. Tuy nhiên khách vẫn được hưởng mức chiết
                                khấu<br> hiện tại nếu còn thời hạn.<br> <span
                                style="color: #800000;"><strong>Lưu ý: nhà sách Minh
                                        Khai có thể thay đổi thể lệ hoặc dừng chương trình mà<em><br>
                                            không cần báo trước.</em>
                                </strong></span></li>
                        </ol>
                    </div>
                    <!-- .entry-content -->

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