package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.CongDanBO;
import bo.HoKhauBO;
import bo.LichSuLuuTruBO;

@WebServlet("/XuLyServlet")
public class XuLyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XuLyServlet() {
        super();
    }
    LichSuLuuTruBO lichSuLuuTru = new LichSuLuuTruBO();
    CongDanBO congDan = new CongDanBO();
    HoKhauBO hoKhau = new HoKhauBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String url = "index.jsp";
        String add = request.getParameter("add");
        String edit = request.getParameter("edit");
        String tk = request.getParameter("tk");
        String quanLyCongDan = request.getParameter("quanLyCongDan");
        String quanLyHoKhau = request.getParameter("quanLyHoKhau");
        request.setAttribute("ListLichSuLuuTru", lichSuLuuTru.getListLichSuLuuTru());
        request.setAttribute("ListCongDan", congDan.getListCongDan());
        request.setAttribute("ListHoKhau", hoKhau.getListHoKhau());
        if(add != null) {
            url = "Them.jsp";
        }
        if(edit != null) {
            url = "Sua.jsp";
        }
        if(tk != null) {
            url = "ThongKe.jsp";
        }
        if(quanLyCongDan != null) {
            url = "CongDan.jsp";
        }
        if(quanLyHoKhau != null) {
            url = "HoKhau.jsp";
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
