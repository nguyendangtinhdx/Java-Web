package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.KhachHangBo;

@WebServlet("/QuanLyKhachHangServlet")
public class QuanLyKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuanLyKhachHangServlet() {
        super();
    }
    KhachHangBo khachHang = new KhachHangBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String loai = request.getParameter("loai");
        String maKhachHang = request.getParameter("maKhachHang");
        try {
            if(loai.equals("xoa")) {
                khachHang.xoaKhachHang(maKhachHang);
                response.sendRedirect("/SellingBooks/admin/QuanLyKhachHang.jsp");
            }
        }catch(Exception e) {
            
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
