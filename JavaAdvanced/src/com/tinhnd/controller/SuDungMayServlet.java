package com.tinhnd.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tinhnd.bean.SuDungMayBEAN;
import com.tinhnd.bo.SuDungMayBO;
import com.tinhnd.commond.Check;

@WebServlet("/SuDungMayServlet")
public class SuDungMayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SuDungMayServlet() {
        super();
    }
    SuDungMayBO suDungMayBO = new SuDungMayBO();
    Check check = new Check();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String url = "MainServlet?danhSachDangKy=1";

        String loai = request.getParameter("loai");

        String mkh = request.getParameter("maKH");
        String mm = request.getParameter("maMay");
        String ngayBatDauSuDung = request.getParameter("ngayBatDauSuDung");
        String gioBatDauSuDung = request.getParameter("gioBatDauSuDung");
        String thoiGianSuDung = request.getParameter("thoiGianSuDung");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date nbdsd = null;
        try {
            nbdsd = df.parse(ngayBatDauSuDung);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String nbdsdE = "", gbdsdE = "", tgsdE="";
        if(ngayBatDauSuDung.equals("")) {
            nbdsdE = "Ngày bắt đầu sử dụng không được để trống";
            request.setAttribute("nbdsdE", nbdsdE);
        }
        if(gioBatDauSuDung.equals("")) {
            gbdsdE = "Giờ bắt đầu sử dụng không được để trống";
            request.setAttribute("gbdsdE", gbdsdE);
        }
        if(thoiGianSuDung.equals("")) {
            tgsdE = "Thời gian sử dụng không được để trống";
            request.setAttribute("tgsdE", tgsdE);
        }
        String gbdsd = "", gbdsdToParse = "";
        SimpleDateFormat df2 = new SimpleDateFormat("HH:mm");

        if(gioBatDauSuDung.equals("")) {
            gbdsdE = "Giờ bắt đầu sử dụng không được để trống";
            request.setAttribute("gsdE", gbdsdE);
        }
        try {
            gbdsdToParse = df2.parse(gioBatDauSuDung).toString();
            gbdsd = gioBatDauSuDung;
            if(!check.checkHour(gioBatDauSuDung)) {
                gbdsdE = "Giờ bắt đầu sử dụng sai định dạng";
                request.setAttribute("gbdsdE", gbdsdE);
            }
        } catch (ParseException e) {
//            e.printStackTrace();
            gbdsdE = "Giờ bắt đầu sử dụng sai định dạng";
            request.setAttribute("gbdsdE", gbdsdE);
        }

        if (loai.equals("them")) {
            if(nbdsdE.length() ==0 && gbdsdE.length() == 0 && tgsdE.length() == 0) {
                SuDungMayBEAN m = new SuDungMayBEAN();
                m.setMaKH(mkh);
                m.setMaMay(mm);
                m.setNgayBatDauSuDung(nbdsd);
                m.setGioBatDauSuDung(gbdsd);
                m.setThoiGianSuDung(thoiGianSuDung);
                
                suDungMayBO.themSuDungMay(m);
            }else {
                url = "MainServlet?themSuDungMay=1";
            }
            
        }
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
		
	}

}
