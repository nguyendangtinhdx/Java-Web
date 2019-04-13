package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.LichSuLuuTruBO;

@WebServlet("/LichSuLuuTruServlet")
public class LichSuLuuTruServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LichSuLuuTruServlet() {
        super();
    }
     LichSuLuuTruBO lichSuLuuTru = new LichSuLuuTruBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String loai = request.getParameter("loai");
        String mhd = request.getParameter("tgbt");
        if(loai.equals("xoa")) {
//            lichSuLuuTruBO.xoaLichSu(n);
            response.sendRedirect("XuLyServlet");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
