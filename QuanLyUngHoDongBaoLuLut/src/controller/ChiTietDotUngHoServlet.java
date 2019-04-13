package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ChiTietDotUngHoBEAN;
import bo.ChiTietDotUngHoBO;

@WebServlet("/ChiTietDotUngHoServlet")
public class ChiTietDotUngHoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ChiTietDotUngHoServlet() {
        super();
    }
    ChiTietDotUngHoBO chiTietDotUngHo = new ChiTietDotUngHoBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String loai = request.getParameter("loai");
        String htuh = request.getParameter("hinhThucUngHo");
        if (loai.equals("xoa")) {
            chiTietDotUngHo.xoaChiTietHoatDong(htuh);
            response.sendRedirect("XuLyServlet?chiTietDotUngHo=1");
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		  response.setCharacterEncoding("utf-8");
	        request.setCharacterEncoding("utf-8");
	        String url = "XuLyServlet?chiTietDotUngHo=1";
	       
	        String loai = request.getParameter("loai");
	        
	        
	        String mduh = request.getParameter("maDotUngHo");
	        String htuh = request.getParameter("hinhThucUngHo");
	        String soLuongUngHo = request.getParameter("soLuongUngHo");
	        String dvt = request.getParameter("donViTinh");
	        int sl = 1;
	        if(soLuongUngHo != null) {
	            sl = Integer.parseInt(soLuongUngHo);
	        }
	        String htuhE = "", dvtE = "";
	        if(htuh.equals("")) {
	            htuhE = "Vui lòng nhập hình thức ủng hộ";
	            request.setAttribute("htuhE", htuhE);
	        }
	        else {
	            if(chiTietDotUngHo.checkMa(htuh)) {
	                htuhE = "Hình thức ủng hộ đã tồn tại";
	                request.setAttribute("htuhE", htuhE);
	            }
	        }
	        if(dvt.equals("")) {
	            dvtE = "Vui lòng nhập đơn vị tính";
	            request.setAttribute("dvtE", dvtE);
            }

	        if(loai.equals("them")) {
	            if(htuhE.length() == 0 && dvtE.length() == 0) {
    	            ChiTietDotUngHoBEAN ctduh= new ChiTietDotUngHoBEAN();
    	            ctduh.setMaDotUngHo(mduh);
    	            ctduh.setHinhThucUngHo(htuh);
    	            ctduh.setSoLuongUngHo((long)sl);
    	            ctduh.setDonViTinh(dvt);
    	            
    	            chiTietDotUngHo.themChiTietDotUngHo(ctduh);
	            }else {
	                url = "XuLyServlet?addChiTietDotUngHo=1";
	            }
	            
	        }
	        if(loai.equals("sua")) {
	            if(dvtE.length() == 0) {
	                chiTietDotUngHo.suaChiTietDotUngHo(new ChiTietDotUngHoBEAN(mduh, htuh, (long)sl, dvt));
	            }else {
	                url = "XuLyServlet?editChiTietDotUngHo=1";
	            }
	         }
	        
	        RequestDispatcher rd = request.getRequestDispatcher(url);
	        rd.forward(request, response);
	}

}
