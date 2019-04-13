package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DotUngHoBEAN;
import bo.DotUngHoBO;

@WebServlet("/DotUngHoServlet")
public class DotUngHoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DotUngHoServlet() {
        super();
    }
    DotUngHoBO dotUngHo = new DotUngHoBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String loai = request.getParameter("loai");
        String mduh = request.getParameter("maDotUngHo");
        if (loai.equals("xoa")) {
            dotUngHo.xoaHoatDong(mduh);
            response.sendRedirect("XuLyServlet?dotUngHo=1");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String url = "XuLyServlet?dotUngHo=1";
       
        String loai = request.getParameter("loai");
        
        
        String mduh = request.getParameter("maDotUngHo");
        String mdvuh = request.getParameter("maDonViUngHo");
        String ngay = request.getParameter("ngayUngHo");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date nuh = null;
        try {
            nuh = df.parse(ngay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String mduhE = "", nuhE = "";
        if(mduh.equals("")) {
            mduhE = "Vui lòng nhập mã đợt ủng hộ";
            request.setAttribute("mduhE", mduhE);
        }
        else {
            if(dotUngHo.checkMa(mduh)) {
                mduhE = "Mã đợt ủng hộ đã tồn tại";
                request.setAttribute("mduhE", mduhE);
            }
        }
        if(ngay.equals("")) {
            nuhE = "Vui lòng nhập ngày ủng hộ";
            request.setAttribute("nuhE", nuhE);
        }

        if(loai.equals("them")) {
            if(mduhE.length() == 0 && nuhE.length() == 0) {
                DotUngHoBEAN duh= new DotUngHoBEAN();
                duh.setMaDotUngHo(mduh);
                duh.setMaDonViUngHo(mdvuh);
                duh.setNgayUngHo(nuh);
    
                dotUngHo.themDotUngHo(duh);
            }
            else {
                url = "XuLyServlet?addDotUngHo=1";
            }
        }
        if(loai.equals("sua")) {
            if(nuhE.length() == 0) {
                dotUngHo.suaDotUngHo(new DotUngHoBEAN(mduh, mdvuh, nuh));
            }
            else {
                url = "XuLyServlet?editDotUngHo=1";
            }
         }
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

}
