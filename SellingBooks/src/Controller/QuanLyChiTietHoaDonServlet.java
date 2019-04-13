package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.ChiTietHoaDonBo;

@WebServlet("/QuanLyChiTietHoaDonServlet")
public class QuanLyChiTietHoaDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuanLyChiTietHoaDonServlet() {
        super();
    }
    ChiTietHoaDonBo chiTietHoaDon = new ChiTietHoaDonBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String loai = request.getParameter("loai");
        String maChiTietHoaDon = request.getParameter("maChiTietHoaDon");
        try {
            if(loai.equals("xoa")) {
                chiTietHoaDon.xoaChiTietHoaDon(maChiTietHoaDon);
                response.sendRedirect("/SellingBooks/admin/QuanLyChiTietHoaDon.jsp");
            }
        }catch(Exception e) {
            
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        
        String loai = request.getParameter("loai");
        String maChiTietHoaDon= request.getParameter("maChiTietHoaDon");
        String sl= request.getParameter("soLuong");
        int soLuong = 1;
        int maCTHD = 1;
        if(maChiTietHoaDon != null) {
           maCTHD = Integer.parseInt(maChiTietHoaDon);
        }
        if(sl != null) {
            soLuong = Integer.parseInt(sl);
        }
        String url = "";
        try {
                if(loai.equals("sua")) {
                            chiTietHoaDon.suaChiTietHoaDon((long)maCTHD,(long)soLuong);
                            url = "/admin/QuanLyChiTietHoaDon.jsp";
                }
          
        }catch(Exception e) {
            
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

}
