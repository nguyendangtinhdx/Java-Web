package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MayTinhBEAN;
import bo.MayTinhBO;

@WebServlet("/MayTinhServlet")
public class MayTinhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MayTinhServlet() {
        super();
    }
    MayTinhBO mayTinhBO = new MayTinhBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String loai = request.getParameter("loai");
        String ma = request.getParameter("ma");
        if(loai.equals("xoaMayTinh")) {
            mayTinhBO.xoaMay(ma);
            response.sendRedirect("MainServlet?danhSachMayTinh=1");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String url = "MainServlet";

        String loai = request.getParameter("loai");

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String g = request.getParameter("gia");
        String sl = request.getParameter("soLuong");
        String nsx = request.getParameter("ngaySanXuat");
        String maHang = request.getParameter("maHang");

        int gia = 1, soLuong = 1;
        if(g != null) {
            gia = Integer.parseInt(g);
        }
        if(sl != null) {
            soLuong = Integer.parseInt(sl);
        }
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySanXuat = null;
        try {
            ngaySanXuat = df.parse(nsx);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String s[] = nsx.split("[-]");
        
        
        if (loai.equals("them")) {
            if(mayTinhBO.checkMa(ma)){
                request.setAttribute("errorMa", "Mã máy tính đã tồn tại !");
                url = "MainServlet?themMayTinh=1";
            }else if(Integer.parseInt(s[0]) < 1900) {
                request.setAttribute("errorNgaySanXuat", "Ngày sản xuất phải >= 1900 !");
                url = "MainServlet?themMayTinh=1";
            }
            else {
                mayTinhBO.themMay(new MayTinhBEAN(ma, ten, gia, soLuong, ngaySanXuat, maHang));
                url = "MainServlet?danhSachMayTinh=1";
            }
        }
        if (loai.equals("sua")) {
            mayTinhBO.suaMay(new MayTinhBEAN(ma, ten, gia, soLuong, ngaySanXuat, maHang));
            url = "MainServlet?danhSachMayTinh=1";
        } 
        
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
		
	}

}
