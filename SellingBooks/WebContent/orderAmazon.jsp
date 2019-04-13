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
<title>Đặt hàng Amazon</title>
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
                        <div style="margin-bottom: 20px; text-align: center;">
                            <a href="http://www.amazon.com" target="_blank"> <img
                                src="image/img_amazon.jpg" alt="" width="160" height="42">
                            </a>
                        </div>
                        <ul>
                            <li><strong>Bước 1:</strong> Quý khách tìm tựa sách trên website <a
                                href="http://www.Amazon.com">www.Amazon.com</a>;</li>
                            <li><strong>Bước 2:</strong> Copy đường link của quyển sách cần tìm
                                và gửi email cho Minh Khai theo địa chỉ mail của Nhà sách: <a
                                href="mailto:mk.book@minhkhai.com.vn"><strong>mk.book@minhkhai.com.vn</strong></a><strong>.
                            </strong>Minh Khai sẽ gửi bản báo giá cho Quý khách qua email.</li>
                        </ul>
                        <strong>Lưu ý: </strong>
                        <ul>
                            <li>Minh Khai <strong>không xuất hóa đơn VAT</strong> đối với sách
                                đặt mua từ Amazon;
                            </li>
                            <li>Bảng báo giá <strong>chưa bao gồm phí vận chuyển</strong> hàng
                                từ Minh Khai đến nơi của Quý khách;
                            </li>
                            <li>Quý khách vui lòng <strong>kiểm tra lại</strong> tên sách cũng
                                như số ISBN. Nếu Quý khách đã xác nhận đơn hàng, Minh Khai sẽ không
                                chịu trách nhiệm nếu xảy ra sai sót về việc đặt nhầm sách;
                            </li>
                            <li>Vì Amazon đã thay đổi cách thức chuyển hàng nên Minh Khai không
                                thể thông báo thời gian chính xác (thường là khoảng từ 4 – 8 tuần
                                sách về đến Minh Khai). Khi nào hàng về, Minh Khai sẽ liên hệ với
                                Quý khách. <strong>Quý khách không được đơn phương hủy bỏ
                                    Đơn đặt hàng.</strong>
                            </li>
                            <li>Minh Khai sẽ tiến hành mua hàng khi đã nhận đủ tiền từ Quý
                                khách.</li>
                            <li>Thanh toán: có 2 hình thức:</li>
                        </ul>
                    </div>

                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <form action="index.aspx?q=contact" method="post"
                            onsubmit="return doFormSubmit()">
                            <div
                                style="padding-top: 10px; padding-left: 10px; clear: both; height: auto">

                                <br>

                                <table width="100%">
                                    <tbody>
                                        <tr>
                                            <td colspan="2"><span id="msgErr"
                                                style="color: red"></span></td>
                                        </tr>
                                        <tr>
                                            <td width="120px" style="padding-top: 4px" valign="top"><span
                                                style="color: black">Email <span
                                                    style="color: red">*</span></span></td>
                                            <td style="padding-top: 4px"><input type="text"
                                                style="width: 55%;" id="Email" name="Email"
                                                class="form-control"></td>
                                        </tr>
                                        <tr>
                                            <td width="120px" style="padding-top: 4px" valign="top"><span
                                                style="color: black">Tên <span
                                                    style="color: red">*</span></span></td>
                                            <td style="padding-top: 4px"><input type="text"
                                                style="width: 55%;" id="Name" name="Name"
                                                class="form-control"></td>
                                        </tr>
                                        <tr>
                                            <td width="120px" style="padding-top: 4px" valign="top"><span
                                                style="color: black">Phone <span
                                                    style="color: red">*</span></span></td>
                                            <td style="padding-top: 4px"><input type="text"
                                                style="width: 55%;" id="Phone" name="Phone"
                                                class="form-control"></td>
                                        </tr>

                                        <tr>
                                            <td width="120px" style="padding-top: 4px" valign="top"><span
                                                style="color: black">Địa chỉ liên hệ <span
                                                    style="color: red">*</span></span></td>
                                            <td style="padding-top: 4px"><textarea
                                                    style="width: 90%" rows="3" id="Address"
                                                    name="Address" class="form-control"></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="120px" style="padding-top: 4px" valign="top"><span
                                                style="color: black">Link Amazon <span
                                                    style="color: red">*</span></span></td>
                                            <td style="padding-top: 4px"><textarea
                                                    style="width: 90%" rows="3" id="Comment"
                                                    name="Comment" class="form-control"></textarea>
                                            </td>
                                        </tr>

                                    </tbody>
                                </table>
                                <br> Ghi chú: Phần đánh dấu <span style="color: red">(*)</span>
                                là bắt buộc. Bạn điền thông tin bằng font chữ Việt Unicode hoặc
                                không dấu.
                                <div style="width: auto; border-bottom: #d6d6d6 1px solid;">
                                    &nbsp;</div>
                                <br>
                                <center>
                                    <input type="submit" value="Gửi yêu cầu" class="btn btn-warning">
                                </center>

                            </div>
                        </form>
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