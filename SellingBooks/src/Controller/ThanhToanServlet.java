package Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ChiTietHoaDonBean;
import Bean.HangBean;
import Bean.HoaDonBean;
import Bean.KhachHangBean;
import Bo.ChiTietHoaDonBo;
import Bo.GioHangBo;
import Bo.HoaDonBo;

@WebServlet("/ThanhToanServlet")
public class ThanhToanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThanhToanServlet() {
        super();
    }
    private final HoaDonBo hoaDon = new HoaDonBo();
    private final ChiTietHoaDonBo chiTietHoaDon = new ChiTietHoaDonBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		HttpSession session = request.getSession();
		GioHangBo giohang = (GioHangBo) session.getAttribute("giohang");
		KhachHangBean khachhang = (KhachHangBean) session.getAttribute("tendangnhap");
		try {
/*		    long id = new Date().getTime();*/
		    HoaDonBean hoadon = new HoaDonBean();
		    hoadon.setMaKhachHang(khachhang.getMaKhachHang());
		    hoadon.setNgayMua(new Timestamp(new Date().getTime()));
		    hoadon.setDaMua(false);
		  /*  hoaDon.themHoaDon(hoadon);*/
		    hoaDon.themHoaDon(hoadon);
		    for(Map.Entry<String, HangBean> list : giohang.getHang().entrySet()) {
		        chiTietHoaDon.themChiTietHoaDon(new ChiTietHoaDonBean((long)0,
		                list.getValue().getSach().getMaSach(), (long)list.getValue().getSoLuong(), 
		                (long)0, (float)list.getValue().getSach().getGia()));
		    }
		    giohang = new GioHangBo();
		    session.setAttribute("giohang", giohang);
		}catch(Exception e) {
		    e.printStackTrace();
		}
		response.sendRedirect("XuLyServlet");
	}

}
