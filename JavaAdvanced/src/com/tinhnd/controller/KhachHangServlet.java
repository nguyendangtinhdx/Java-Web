package com.tinhnd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tinhnd.bean.KhachHangBEAN;
import com.tinhnd.bo.KhachHangBO;
import com.tinhnd.commond.Check;

@WebServlet("/KhachHangServlet")
public class KhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public KhachHangServlet() {
        super();
    }
    KhachHangBO khachHangBO = new KhachHangBO();
    Check check = new Check();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String loai = request.getParameter("loai");
        String mkh = request.getParameter("maKH");
        if(loai.equals("xoaKH")) {
            khachHangBO.xoaKhachHang(mkh);
            response.sendRedirect("MainServlet?danhSachKhachHang=1");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String url = "MainServlet?danhSachKhachHang=1";

        String loai = request.getParameter("loai");

        String mkh = request.getParameter("maKH");
        String tkh = request.getParameter("tenKH");
        String dc = request.getParameter("diaChi");
        String sdt = request.getParameter("soDienThoai");
        String email = request.getParameter("diaChiEmail");

        String mkhE = "",tkhE = "", dcE = "",sdtE = "",emailE = "";
//        if(mkh.equals("")) {
//            mkhE = "Mã khách hàng được để trống";
//            request.setAttribute("mkhE", mkhE);
//        }
        if (khachHangBO.checkMaKhachHang(mkh)) {
            mkhE = "Mã khách hàng đã tồn tại";
            request.setAttribute("mkhE", mkhE);
        }
        if(tkh.equals("")) {
            tkhE = "Tên khách hàng không được để trống";
            request.setAttribute("tkhE", tkhE);
        }
        if(dc.equals("")) {
            dcE = "Địa chỉ không được để trống";
            request.setAttribute("dcE", dcE);
        }
//        if(!check.checkPhone(sdt)) {
//            sdtE = "Số điện thoại không đúng định dạng";
//            request.setAttribute("sdtE", sdtE);
//        }
//        if(!check.checkEmail(email)) {
//            emailE = "Email không đúng định dạng";
//            request.setAttribute("emailE", emailE);
//        }

        if (loai.equals("them")) {
            if(mkhE.length() == 0 && tkhE.length() == 0 && dcE.length() == 0 && sdtE.length() == 0 && emailE.length() == 0) {
                KhachHangBEAN kh = new KhachHangBEAN();
                kh.setMaKH(mkh);
                kh.setTenKH(tkh);
                kh.setDiaChi(dc);
                kh.setSoDienThoai(sdt);
                kh.setDiaChiEmail(email);
                
                khachHangBO.themKhachHang(kh);
            }
            else {
                url = "MainServlet?themKhachHang=1";
            }
        }
        if (loai.equals("sua")) {
            if(tkhE.length() == 0 && dcE.length() == 0 && sdtE.length() == 0 && emailE.length() == 0) {
                khachHangBO.suaKhachHang(new KhachHangBEAN(mkh, tkh, dc,sdt,email));
            }else {
                url = "MainServlet?suaKH=1";
            }
        } 
        
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

}
