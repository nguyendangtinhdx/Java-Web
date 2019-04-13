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
<title>Tài khoản</title>
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
                    <div style="float: left; padding-top: 5px; width: 100%; height: auto; min-width: 530px">
                        <!-- Search Box -->


                        <div
                            style="padding-top: 10px; padding-left: 10px; clear: both; height: auto">
                        </div>


                        <div style="color: black; padding-left: 10px; padding-top: 10px;">
                             <h2 align="center" class="tieude">Quy trình giao dịch</h2><br>
                            <p>
                                <strong>Cách 1: Thanh toán trước thông qua bưu điện, hoặc
                                    chuyển khoản (internet banking, ngân hàng, ATM):</strong>
                            </p>
                            <ul>
                                <li>Bước 1: Khách hàng đặt hàng</li>
                                <li>Bước 2: Khách hàng thanh toán trước</li>
                                <li>Bước 3: Khách hàng xác nhận đã thanh toán</li>
                                <li>Bước 4: Minh Khai nhận tiền, thông báo và chuyển hàng</li>
                                <li>Bước 5: Khách hàng kiểm tra và nhận hàng</li>
                            </ul>
                            <p>
                                <strong>Cách 2: Thanh toán sau (chỉ áp dụng đối với Quý
                                    khách trong nội thành Tp.HCM):</strong>
                            </p>
                            <ul>
                                <li>Bước 1: Khách hàng đặt hàng</li>
                                <li>Bước 2: Khách hàng xác thực đơn hàng (email, điện thoại)</li>
                                <li>Bước 3: Minh Khai xác nhận thông tin đơn hàng (email)</li>
                                <li>Bước 4: Minh Khai chuyển hàng</li>
                                <li>Bước 5: Khách hàng nhận hàng và thanh toán</li>
                            </ul>
                            <p>&nbsp;</p>
                            <p>
                                <strong>CÁC BƯỚC ĐẶT HÀNG</strong>
                            </p>
                            <p>
                                <strong><span style="text-decoration: underline;">Bước
                                        1:</span></strong> <strong>Duyệt và chọn sản phẩm: </strong><br> Quý
                                khách có thể tìm sản phẩm bằng một trong 2 cách:
                            </p>
                            <p>
                                <strong>Cách 1:</strong> Sử dụng hộp tìm kiếm ở trên cùng:
                            </p>
                            <img src="image/help/timkiem.png" alt="" width="200"
                                height="33">
                            <p>Sau đó sẽ có một Danh sách các kết quả chứa các sản phẩm phù hợp
                                với Từ khóa mà Quý khách vừa tìm kiếm.</p>
                            <p>
                                <strong>Cách 2:</strong> Tìm qua Danh mục sách phía bên trái
                            </p>
                            <ul>
                                <li>Xem và chọn tựa sách cần tìm;</li>
                                <li>Click vào mục <img
                                    src="image/help/themvaogiohang.png" alt="" width="130"
                                    height="30"></li>
                                <li>Xác nhận số lượng trong ô Số lượng;</li>
                                <li>Chọn “<strong>Tiếp tục mua hàng”</strong> để thêm sản phẩm
                                    vào giỏ hàng hoặc chọn “<strong>Thanh toán</strong>” để tiến
                                    hành đặt sách.
                                </li>
                            </ul>
                            <p>
                                <strong><span style="text-decoration: underline;">Bước
                                        2:</span></strong><strong> Xem thông tin giỏ hàng:</strong>
                            </p>
                            <ul>
                                <li>Hệ thống hiển thị các thông tin về sản phẩm Quý khách đã
                                    đặt mua như chủng loại, đơn giá, số lượng, trị giá,...Tại đây
                                    Quý khách có thể thay đổi số lượng hàng hoá bằng cách nhập vào
                                    số lượng trong ô "<strong>Số lượng</strong>".
                                </li>
                                <li>Nếu muốn trả lại sản phẩm đã chọn (không mua nữa), Quý
                                    khách nhập vào số lượng của sản phẩm đó bằng "0".</li>
                                <li>Mỗi lần thay đổi số lượng của sản phẩm, Quý khách nhớ phải
                                    click vào nút&nbsp;<strong>"Cập nhật giỏ hàng"</strong>&nbsp;để
                                    hệ thống ghi nhận lại những thay đổi trong giỏ hàng của Quý
                                    khách trước khi click chọn<strong>"Thanh toán"</strong>&nbsp;để
                                    sang bước kế tiếp.&nbsp;
                                </li>
                            </ul>
                            <p>
                                <strong><span style="text-decoration: underline;">Bước
                                        3:</span></strong> <strong>Địa chỉ thanh toán và giao hàng:</strong>
                            </p>
                            <ul>
                                <li><strong>Thông tin giao hàng</strong>: Quý khách vui lòng
                                    điền đầy đủ thông tin cá nhân (họ tên, email, địa chỉ liên hệ /
                                    địa chỉ giao hàng, số điện thoại);</li>
                            </ul>
                            <p>
                                <img src="image/help/thanhtoan.png" alt="" width="391"
                                    height="262">
                            </p>
                            <p>
                                Quý khách vui lòng lưu ý nhập chính xác tên và họ người nhận, địa
                                chỉ của người mua hàng &amp; người nhận hàng cũng chính xác tức là
                                gồm: Quốc gia, Tỉnh/Thành phố, Quận/huyện bằng tiếng Việt có dấu. <br>
                                Với trường hợp Đơn hàng Quốc tế vui lòng liên hệ <strong>MinhKhai
                                    Care: mk.book@minhkhai.com.vn</strong>
                            </p>
                            <ul>
                                <li><strong>Thông tin tùy chọn</strong>: Quý khách có thể yêu
                                    cầu xuất hóa đơn đỏ / gói quà / hoặc yêu cầu đặc biệt ở bước
                                    này.</li>
                            </ul>
                            <p>
                                <img src="../../store2/images/helpbuyoption.gif" alt="" width="405"
                                    height="205">
                            </p>
                            <p>
                                <strong><span style="text-decoration: underline;">Bước
                                        4:</span></strong> <strong>Phương thức vận chuyển và thanh toán:</strong>
                            </p>
                            <ul>
                                <li><strong>Phương thức vận chuyển</strong>: tùy theo địa chỉ
                                    giao hàng của Quý khách</li>
                                <li><strong>Phương thức thanh toán</strong>: chọn <strong>“Phương
                                        thức thanh toán”</strong> tùy thuộc địa chỉ giao hàng của Quý khách.</li>
                            </ul>
                            <p>
                                <strong><span style="text-decoration: underline;">Bước
                                        5:</span></strong> <strong>Xem hóa đơn:</strong><br> Hệ thống sẽ hiển
                                thị hoá đơn mua hàng của Quý khách. Trước khi bấm nút “<strong>Đặt
                                    hàng</strong>”, Quý khách cần kiểm tra lại chính xác một lần nữa thông
                                tin Đơn hàng của Quý khách gồm: Tổng giá trị Đơn hàng, số lượng sản
                                phẩm trong giỏ hàng, Chi phí giao hàng. Nếu đồng ý Quý khách
                                click&nbsp;<strong>"Đặt mua hàng"</strong>để kết thúc việc đặt mua
                                hàng.
                            </p>
                            <p>
                                <strong><span style="text-decoration: underline;">Bước
                                        6:</span></strong> <strong>Kết thúc:</strong><br> Hệ thống sẽ gởi email
                                xác nhận đơn hàng cho Quý khách. Xác nhận đơn hàng là việc&nbsp;<strong>Minh
                                    Khai kiểm chứng&nbsp;lại các thông tin đơn hàng </strong>Quý khách<strong>
                                    đã đặt</strong>. Việc làm&nbsp;này có tác dụng như một lời&nbsp;cam kết
                                xác nhận&nbsp;đặt hàng từ Quý khách&nbsp;và Minh Khai có trách nhiệm
                                thực hiện đơn hàng đó.<br> <em>Lưu ý: Để đẩy nhanh tốc độ
                                    xử lý đơn hàng, chúng tôi sẽ không xác nhận lại đơn hàng bằng
                                    điện thoại. Nhân viên Minh Khai sẽ liên hệ với Quý khách để giao
                                    hàng theo yêu cầu.</em>
                            </p>
                            <p>
                                Sau khi đọc xong hướng dẫn và vẫn không biết cách đặt hàng hoặc gặp
                                trục trặc kỹ thuật, vui lòng liên hệ&nbsp;<strong>MinhKhai
                                    Care (028) 3925 0590 – (028) 3925 0591 </strong>(từ 08:00 – 17:00 từ thứ
                                Hai đến thứ Bảy). Nhân viên Minh Khai sẽ giúp Quý khách đặt được đơn
                                hàng mong muốn.
                            </p>
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