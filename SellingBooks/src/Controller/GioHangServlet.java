package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.HangBean;
import Bean.SachBean;
import Bo.GioHangBo;
import Bo.SachBo;

@WebServlet("/GioHangServlet")
public class GioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GioHangServlet() {
        super();
    }
    SachBo sach = new SachBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    HttpSession session = request.getSession();
        String loai = request.getParameter("loai");
        String maSach = request.getParameter("maSach");
        String  sl = request.getParameter("soluong");
        int soluong ;
        if(sl != null) {
            
             soluong = Integer.parseInt(sl);
        }
        else {
            soluong = 1;
        }
        GioHangBo giohang = (GioHangBo) session.getAttribute("giohang");
        try {
            SachBean sachBean = sach.getSach(maSach);
            switch(loai) {
                case "them":
                    if(session.getAttribute("giohang") == null) {
                        giohang = new GioHangBo();
                        session.setAttribute("giohang", giohang);
                    }
                    giohang = (GioHangBo) session.getAttribute("giohang");
                    if(giohang.getHang().containsKey(maSach)) {
                        giohang.them(maSach, new HangBean(sachBean, giohang.getHang().get(maSach).getSoLuong()));
                    }
                    else {
                        giohang.them(maSach, new HangBean(sachBean,(long)1));
                    }
                    break;
                case "cong":
                    
                    if(giohang.getHang().containsKey(maSach)) {
                        
                        giohang.cong(maSach, new HangBean(sachBean, giohang.getHang().get(maSach).getSoLuong()),(long)soluong);
                    }
                    else {
                        giohang.cong(maSach, new HangBean(sachBean,(long)1),(long)soluong);
                    }
                    break;
                case "tru":
                    if(giohang.getHang().containsKey(maSach)) {
                        giohang.tru(maSach, new HangBean(sachBean, giohang.getHang().get(maSach).getSoLuong()),(long)soluong);
                    }
                    else {
                        giohang.tru(maSach, new HangBean(sachBean,(long)1),(long)soluong);
                    }
                    break;
                case "xoa":
                    giohang.xoa(maSach);
                    break;
                case "xoaDonHang":
                    giohang = null;
                    break;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("giohang", giohang);
        response.sendRedirect("cart.jsp");
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
