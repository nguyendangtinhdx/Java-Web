package com.tinhnd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tinhnd.bean.DichVuBEAN;
import com.tinhnd.bean.MayBEAN;
import com.tinhnd.bo.DichVuBO;

@WebServlet("/DichVuServlet")
public class DichVuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DichVuServlet() {
        super();
    }
    DichVuBO dichVuBO = new DichVuBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String loai = request.getParameter("loai");
        String mdv = request.getParameter("maDV");
        if(loai.equals("xoaDV")) {
            dichVuBO.xoaDichVu(mdv);
            response.sendRedirect("MainServlet?danhSachDichVu=1");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String url = "MainServlet?danhSachDichVu=1";

        String loai = request.getParameter("loai");

        String mdv = request.getParameter("maDV");
        String tdv = request.getParameter("tenDV");
        String dvt = request.getParameter("donViTinh");
        String donGia = request.getParameter("donGia");
        int dg = 1;
        if(donGia != null) {
            dg = Integer.parseInt(donGia);
        }
        String mdvE = "",tdvE = "", dvtE="";
//        if(mdv.equals("")) {
//            mdvE = "Mã dịch vụ được để trống";
//            request.setAttribute("mdvE", mdvE);
//        }
        if (dichVuBO.checkMaDV(mdv)) {
            mdvE = "Mã dịch vụ đã tồn tại";
            request.setAttribute("mdvE", mdvE);
        }
        if(tdv.equals("")) {
            tdvE = "Tên dịch vụ không được để trống";
            request.setAttribute("tdvE", tdvE);
        }
        if(dvt.equals("")) {
            dvtE = "Đơn vị tính không được để trống";
            request.setAttribute("dvtE", dvtE);
        }

        if (loai.equals("them")) {
            if(mdvE.length() == 0 && tdvE.length() == 0 && dvtE.length() == 0) {
                DichVuBEAN dv = new DichVuBEAN();
                dv.setMaDV(mdv);
                dv.setTenDV(tdv);
                dv.setDonViTinh(dvt);
                dv.setDonGia(dg);
                
                dichVuBO.themDichVu(dv);
            }else {
                url = "MainServlet?themDichVu=1";
            }
        }
        if (loai.equals("sua")) {
            if(tdvE.length() == 0 && dvtE.length() == 0) {
                dichVuBO.suaDichVu(new DichVuBEAN(mdv, tdv, dvt,dg));
            }else {
                url = "MainServlet?suaDV=1";
            }
        } 
        
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

}
