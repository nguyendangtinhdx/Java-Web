package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.HangBO;
import bo.MayTinhBO;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
    }
    MayTinhBO mayTinhBO = new MayTinhBO();
    HangBO hangBO = new HangBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String url = "index.jsp";
        
        String loai = request.getParameter("loai");

        String danhSachMayTinh = request.getParameter("danhSachMayTinh");
        String themMayTinh = request.getParameter("themMayTinh");
        String suaMayTinh = request.getParameter("suaMayTinh");
        String danhSachHang= request.getParameter("danhSachHang");
        String themHang = request.getParameter("themHang");
        String suaHang = request.getParameter("suaHang");

        String keyMayTinh = request.getParameter("keyMayTinh");
        
        if(danhSachMayTinh != null) {
            url="danhSachMayTinh.jsp";
        }
        if(themMayTinh != null) {
            url="themMayTinh.jsp";
        }
        if(suaMayTinh != null) {
            url="suaMayTinh.jsp";
        }
        if(keyMayTinh != null) {
            if(loai.equals("timKiemMayTinh")) {
                request.setAttribute("ListMayTinh", mayTinhBO.timKiemMay(keyMayTinh));
                url="danhSachMayTinh.jsp";
            }
        }else {
            request.setAttribute("ListMayTinh", mayTinhBO.getListMay());
        }
        
        
        request.setAttribute("ListHang", hangBO.getListHang());
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		
	}

}
