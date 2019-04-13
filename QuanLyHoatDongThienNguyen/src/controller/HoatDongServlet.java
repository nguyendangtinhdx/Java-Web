package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.HoatDongBEAN;
import bo.HoatDongBO;

@WebServlet("/HoatDongServlet")
public class HoatDongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HoatDongServlet() {
        super();
    }
    HoatDongBO hoatDong = new HoatDongBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String loai = request.getParameter("loai");
        String mhd = request.getParameter("maHoatDong");
        if(loai.equals("xoa")) {
            hoatDong.xoaHoatDong(mhd);
            response.sendRedirect("XuLyServlet");
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String url = "XuLyServlet";
       
        String loai = request.getParameter("loai");
        
        
        String mhd = request.getParameter("maHoatDong");
        String thd = request.getParameter("tenHoatDong");
        String mthd = request.getParameter("moTaHoatDong");
        String bd = request.getParameter("ngayGioBatDau");
        String kt = request.getParameter("ngayGioKetThuc");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date ngbd = null, ngkt = null;
        try {
                ngbd =  df.parse(bd);
                ngkt = df.parse(kt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        String soLuongTT = request.getParameter("soLuongToiThieu");
        int sltt = 1, sltd = 1;
        if(soLuongTT != null) {
            sltt = Integer.parseInt(soLuongTT);
        }
        String soLuongTD = request.getParameter("soLuongToiDa");
        if(soLuongTD != null) {
            sltd = Integer.parseInt(soLuongTD);
        }
        
        String thdk = request.getParameter("thoiHanDangKy");
        String tt = request.getParameter("trangThai");
        String mtv = request.getParameter("maThanhVien");
        String ldhhd = request.getParameter("lyDoHuyHoatDong");
        
        String mhdE = "", thdE = "", mthdE = "",ngbdE= "" ,ngktE = "",thdkE = "", ldhhdE = "";
        if(mhd.equals("")) {
            mhdE = "Vui lòng nhập mã hoạt động";
            request.setAttribute("mhdE", mhdE);
        }
        else {
            if(hoatDong.checkMa(mhd)) {
                mhdE = "Mã hoạt động đã tồn tại";
                request.setAttribute("mhdE", mhdE);
            }
        }
        if(thd.equals("")) {
            thdE = "Vui lòng nhập tên hoạt động";
            request.setAttribute("thdE", thdE);
        }
        if(mthd.equals("")) {
            mthdE = "Vui lòng nhập mô tả hoạt động";
            request.setAttribute("mthdE", mthdE);
        }
        if(bd.equals("")) {
            ngbdE = "Vui lòng nhập ngày giờ bắt đầu";
            request.setAttribute("ngbdE", ngbdE);
        }
        if(kt.equals("")) {
            ngktE = "Vui lòng nhập ngày giờ kết thúc";
            request.setAttribute("ngktE", ngktE);
        }
        if(thdk.equals("")) {
            thdkE = "Vui lòng nhập thời hạn đăng ký";
            request.setAttribute("thdkE", thdkE);
        }

        if(loai.equals("them")) {
            if(mhdE.length() == 0 && thdE.length() == 0 && mthdE.length() == 0 && ngbdE.length() == 0 && ngbdE.length() == 0 && thdkE.length() == 0) {
                HoatDongBEAN hd = new HoatDongBEAN();
                hd.setMaHoatDong(mhd);
                hd.setTenHoatDong(thd);
                hd.setMoTaHoatDong(mthd);
                hd.setNgayGioBatDau(ngbd);
                hd.setNgayGioKetThuc(ngkt);
                hd.setSoLuongToiThieu((long)sltt);
                hd.setSoLuongToiDa((long)sltd);
                hd.setThoiHanDangKy(thdk);
                hd.setTrangThai(tt);
                hd.setMaThanhVien(mtv);
                hd.setLyDoHuyHoatDong("");
    
                hoatDong.themHoatDong(hd);
            }
            else {
               url = "XuLyServlet?add=1";
            }
        }
        
       if(loai.equals("sua")) {
           if(ldhhd.equals("")) {
               ldhhdE = "Vui lòng nhập lý do hủy hoạt động";
               request.setAttribute("ldhhdE", ldhhdE);
           }
           if(thdE.length() == 0 && mthdE.length() == 0 && ngbdE.length() == 0 && ngbdE.length() == 0 && thdkE.length() == 0 && ldhhdE.length() == 0) {
               hoatDong.suaHoatDong(new HoatDongBEAN(mhd, thd, mthd, ngbd, ngkt, (long)sltt, (long)sltd, thdk, tt, mtv, ldhhd));
           }
           else {
               url = "XuLyServlet?edit=1";
           }
       }
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

}
