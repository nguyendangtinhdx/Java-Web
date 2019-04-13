<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thêm thông tin sinh viên</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<!-- header -->
	<div id="header">
	
	</div><!--end header -->
	
	<!-- menu -->
	<div id="menu">
		<ul>
			<li><a href="themsv.jsp">Thêm thông tin sinh viên</a></li>		
		</ul>
		<ul>
			<li><a href="getDS.jsp">Nhập điểm sinh viên</a></li>		
		</ul>
	</div><!--end menu -->
	
	<!-- content -->
	<div id="content">
		<!-- class servlet là addsv -->
		<form action="addsv" method="post" onsubmit="return ktra()">
			<table>
				<tr>
					<td>Họ tên</td>
					<td><input type="text" name="ht" id="ht"></td>
				</tr>
				<tr>
					<td>Lớp</td>
					<td><input type="text" name="lop" id="lop"></td>
				</tr>
				<tr>
					<td>Giới tính</td>
					<td>
						<input type="radio" name="gt" value="1" checked="checked">Nam		
						<input type="radio" name="gt" value="0">Nữ					
					</td>
				</tr>
				<tr>
					<td>Chuyên ngành</td>
					<td>
						<select name="cn">
							<option value="1" selected="selected">Công nghệ thông tin</option>
							<option value="2">Điện tử viễn thông</option>
							<option value="3">Mạng truyền thông</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="dk" value="Đăng ký"></td>
				<!-- 	<td><input type="submit" name="huy" id="huy" value="Hủy" onclick="reset()"></td> -->
				</tr>
			</table>		
		</form>
		<script type="text/javascript">
			/* function reset(){
				document.getElementById("ht").value = "";
				document.getElementById("lop").value = "";
			} */
			function ktra() {// trả về thông báo khi chưa nhập đầy đủ thông tin
				var ht = document.getElementById("ht").value; // lấy giá trị trong ô text
				var lop = document.getElementById("lop").value; // lấy giá trị trong ô text
				if(ht == null || ht=="" || lop == null || lop == ""){
					alert("Yêu cầu nhập đầy đủ thông tin");
					return false;
				}
				else{
					return true;
				}
			}
		</script>
		
		
	</div><!--end content -->
	
	<!-- footer -->
	<div id="footer">
	
	</div><!--end footer-->
</body>
</html>