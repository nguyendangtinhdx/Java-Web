package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.HoatDongBO;
import bo.ThanhVienBO;
import bo.ThongKeBO;

@WebServlet("/XuLyServlet")
public class XuLyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XuLyServlet() {
        super();
    }
    HoatDongBO hoatDong = new HoatDongBO();
    ThanhVienBO thanhVien = new ThanhVienBO();
    ThongKeBO thongKe = new ThongKeBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String url = "index.jsp";
        String add = request.getParameter("add");
        String edit = request.getParameter("edit");
        String tk = request.getParameter("tk");
        request.setAttribute("ListHoatDong", hoatDong.getListHoatDong());
        request.setAttribute("ListThanhVien", thanhVien.getListThanhVien());
        request.setAttribute("ListThongKe", thongKe.getListThongKe());
        if(add != null) {
            url = "Them.jsp";
        }
        if(edit != null) {
            url = "Sua.jsp";
        }
        if(tk != null) {
            url = "ThongKe.jsp";
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
        
	}

}
