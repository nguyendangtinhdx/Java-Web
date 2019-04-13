package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.HoaDonBo;

@WebServlet("/QuanLyHoaDonServlet")
public class QuanLyHoaDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuanLyHoaDonServlet() {
        super();
    }
    HoaDonBo hoadon = new HoaDonBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String loai = request.getParameter("loai");
        String maHoaDon = request.getParameter("maHoaDon");
        try {
            switch(loai) {
                case "xoa":
                    hoadon.xoaHoaDon(maHoaDon);
                    response.sendRedirect("/SellingBooks/admin/QuanLyHoaDon.jsp");
                    break;
                case "xacnhan":
                    hoadon.xacNhanHoaDon(maHoaDon);
                    response.sendRedirect("/SellingBooks/admin/QuanLyHoaDon.jsp");
                    break;
            }
        }catch(Exception e) {
            
        }
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
