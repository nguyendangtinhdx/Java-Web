<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Quản Lý Công Ty Bảo Hiểm | Admin</title>
</head>
<body class="skin-black">
	<table class="table table-bordered table-hover">
	    <thead>
	      <tr>
	        <th>Mã Phiếu</th>
	        <th>Họ Tên</th>
	        <th>Loại Bảo Hiểm</th>
	        <th>Ngày Mua</th>
	        <th>Tình Trạng Thanh Toán</th>
	        <th>Nhân Viên Xác Nhận</th>
	        <th style="width: 19%;">Chức Năng</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:forEach items="${dsKhachHang }" var = "kh">
	      	<tr>
	        <td>${kh.getMaPhieuBaoHiem() }</td>
	        <td>${kh.getHoTen() }</td>
	        <td>${kh.getLoaiBaoHiem() }</td>
	        <td>${kh.getNgayMua() }</td>
	        <td>${kh.getTinhTrangThanhToan() }</td>
	        <td>${kh.getMaNhanVien() }</td>
	        <td style="padding-left: 1px; padding-right: 1px; width: 19%;">
	        	<div class="pull-right hidden-phone">
	        		<button class="btn btn-primary btn-xs"><i onclick="suaNhanVien('${kh.getMaPhieuBaoHiem()}')" class="fa fa-pencil"></i> Chi Tiết</button>
	        		<c:if test="${kh.getMaNhanVien() == null}">
	        			<button class="btn btn-danger btn-xs" onclick="xacNhan('${kh.getMaPhieuBaoHiem()}')"><i class="fa fa-check"></i> Xác Nhận</button>
	        		</c:if>
	        		<c:if test="${kh.getMaNhanVien() != null}">
	        			<button class="btn btn-success btn-xs"><i class="fa fa-check"></i> Đã Xác Nhận</button>
	        		</c:if>
	        		
					<button class="btn btn-default btn-xs" onclick="Xoa('${kh.getMaPhieuBaoHiem()}')"><i class="fa fa-times"></i></button>
				</div>
			</td>
	      </tr>
	      </c:forEach>
	      
	    </tbody>
	  </table>
</body>
</html>