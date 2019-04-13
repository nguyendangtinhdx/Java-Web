package Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.QuanLySachBean;
import Bo.QuanLySachBo;

@WebServlet("/QuanLySachServlet")
public class QuanLySachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuanLySachServlet() {
        super();
    }
    QuanLySachBo sachBo = new QuanLySachBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        
        String loai = request.getParameter("loai");
        String maSach = request.getParameter("maSach");
        try {
            if(loai.equals("xoa")) {
                    sachBo.xoaSach(maSach);
                    response.sendRedirect("/SellingBooks/admin/QuanLySach.jsp");
            }
        }catch(Exception e) {
            
        }
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        
		String loai = request.getParameter("loai");
		String maSach = request.getParameter("maSach");
		String tenSach = request.getParameter("tenSach");
		String tacGia= request.getParameter("tacGia");
		String sl= request.getParameter("soLuong");
        String g = request.getParameter("gia");
        int soLuong = 1, gia = 1000;
        if(sl != null) {
            soLuong = Integer.parseInt(sl);
        }
        if(g != null) {
            gia = Integer.parseInt(g);
        }
		String soTap= request.getParameter("soTap");
		String anh = request.getParameter("anh");
		String maLoai= request.getParameter("maLoai");
		
		String url = "";
		String maSachErr = "", tenSachErr = "", tacGiaErr = "", soTapErr = "", anhErr = "" , soLuongErr = "" , giaErr = "";
		if(maSach.equals("")) {
		    maSachErr = "Vui lòng nhập mã sách";
		    request.setAttribute("maSachErr", maSachErr);
		}
		if(tenSach.equals("")) {
		    tenSachErr = "Vui lòng nhập tên sách";
            request.setAttribute("tenSachErr", tenSachErr);
        }
		if(tacGia.equals("")) {
		    tacGiaErr = "Vui lòng nhập mã sách";
            request.setAttribute("tacGiaErr", tacGiaErr);
        }
		if(soTap.equals("")) {
		    soTapErr = "Vui lòng nhập số tập";
            request.setAttribute("soTapErr", soTapErr);
        }
		if(anh.equals("")) {
		    anhErr = "Vui lòng chọn ảnh";
            request.setAttribute("anhErr", anhErr);
        }
		if(sl.equals("")) {
		    soLuongErr = "Vui lòng nhập số lượng";
            request.setAttribute("soLuongErr", soLuongErr);
        }
		if(g.equals("")) {
		    giaErr = "Vui lòng nhập giá";
            request.setAttribute("giaErr", giaErr);
        }
		try {
            switch(loai) {
                case "them":
                    if(maSachErr.length() == 0 && tenSachErr.length() == 0 && tacGiaErr.length() == 0 &&  soTapErr.length() == 0 && anhErr.length() == 0 && soLuongErr.length() == 0 && giaErr.length() == 0) {
                        QuanLySachBean sach = new QuanLySachBean();
                        sach.setMaSach(maSach);
                        sach.setTenSach(tenSach);
                        sach.setTacGia(tacGia);
                        sach.setSoLuong((long)soLuong);
                        sach.setGia((long)gia);
                        sach.setSoTap(soTap);
                        sach.setAnh(anh);
                        sach.setMaLoai(maLoai);
                        sach.setNgayNhap(new Timestamp(new Date().getTime()));
                        sachBo.themSach(sach);
//                        sachBo.themSach(new QuanLySachBean(maSach, tenSach, tacGia, (long)soLuong, (long)gia, soTap, anh, maLoai, new Timestamp(new Date().getTime())));
                        url = "/admin/QuanLySach.jsp";
                    }
                    else {
                        url = "/admin/ThemSach.jsp";
                    }
                    break;
                case "sua":
                    if(maSachErr.length() == 0 && tenSachErr.length() == 0 && tacGiaErr.length() == 0 &&  soTapErr.length() == 0 && anhErr.length() == 0 && soLuongErr.length() == 0 && giaErr.length() == 0) {
                        sachBo.suaSach(new QuanLySachBean(maSach, tenSach, tacGia, (long)soLuong, (long)gia, soTap, anh, maLoai, new Timestamp(new Date().getTime())));
                        url = "/admin/QuanLySach.jsp";
                    }
                    else {
                        url = "/admin/SuaSach.jsp";
                    }
            }
      
    }catch(Exception e) {
        
    }
    RequestDispatcher rd = request.getRequestDispatcher(url);
    rd.forward(request, response);
		
		
	}

}
