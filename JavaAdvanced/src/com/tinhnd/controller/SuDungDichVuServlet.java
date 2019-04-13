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

import com.tinhnd.bean.SuDungDichVuBEAN;
import com.tinhnd.bo.SuDungDichVuBO;
import com.tinhnd.commond.Check;

@WebServlet("/SuDungDichVuServlet")
public class SuDungDichVuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SuDungDichVuServlet() {
        super();
    }
    SuDungDichVuBO suDungDichVuBO = new SuDungDichVuBO();
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
        String mdv = request.getParameter("maDV");
        String ngaySuDung = request.getParameter("ngaySuDung");
        String gioSuDung = request.getParameter("gioSuDung");
        String soLuong = request.getParameter("soLuong");
        int sl = 1 ;
        if(soLuong != null) {
            sl = Integer.parseInt(soLuong);
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date nsd = null;
        try {
            nsd = df.parse(ngaySuDung);
        } catch (ParseException e) {
//            e.printStackTrace();
        }
        String nsdE = "", gsdE = "", tgsdE;
        if(ngaySuDung.equals("")) {
            nsdE = "Ngày sử dụng không được để trống";
            request.setAttribute("nsdE", nsdE);
        }
        String gsd = "", gsdToParse = "";
        SimpleDateFormat df2 = new SimpleDateFormat("HH:mm");

        if(gioSuDung.equals("")) {
            gsdE = "Giờ sử dụng không được để trống";
            request.setAttribute("gsdE", gsdE);
        }
        try {
            gsdToParse = df2.parse(gioSuDung).toString();
            gsd = gioSuDung;
            if(!check.checkHour(gioSuDung)) {
                gsdE = "Giờ sử dụng sai định dạng";
                request.setAttribute("gsdE", gsdE);
            }
        } catch (ParseException e) {
//            e.printStackTrace();
            gsdE = "Giờ sử dụng sai định dạng";
            request.setAttribute("gsdE", gsdE);
        }
           


        if (loai.equals("them")) {
            if(nsdE.length() == 0 && gsdE.length() == 0) {
                SuDungDichVuBEAN dv = new SuDungDichVuBEAN();
                dv.setMaKH(mkh);
                dv.setMaDV(mdv);
                dv.setNgaySuDung(nsd);
                dv.setGioSuDung(gsd);
                dv.setSoLuong(sl);
                
                suDungDichVuBO.themSuDungDichVu(dv);
            }else {
                url = "MainServlet?themSuDungDichVu=1";
            }
        }
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
		
	}

}
