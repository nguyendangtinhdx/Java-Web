package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.LoaiBean;
import Bo.LoaiBo;

@WebServlet("/QuanLyLoaiServlet")
public class QuanLyLoaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuanLyLoaiServlet() {
        super();
    }
    LoaiBo loaiSach = new LoaiBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        
        String loai = request.getParameter("loai");
        String maLoai = request.getParameter("maLoai");
        try {
                switch(loai) {
                    case "xoa":
                        loaiSach.xoaLoai(maLoai);
                        response.sendRedirect("/SellingBooks/admin/QuanLyLoai.jsp");
                        break;
            }
        }catch(Exception e) {
            
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
		
		String loai = request.getParameter("loai");
		String maLoai = request.getParameter("maLoai");
		String tenLoai = request.getParameter("tenLoai");
		
		String url = "";
		String maLoaiErr = "", tenLoaiErr = "";
		if(maLoai.equals("")) {
		    maLoaiErr = "Vui lòng nhập mã loại";
		    request.setAttribute("maLoaiErr", maLoaiErr);
		}
		if(tenLoai.equals("")) {
            tenLoaiErr = "Vui lòng nhập tên loại";
            request.setAttribute("tenLoaiErr", tenLoaiErr);
        }
		try {
		        switch(loai) {
		            case "them":
		                if(maLoaiErr.length() == 0 && tenLoaiErr.length() == 0) {
    		                loaiSach.themLoai(new LoaiBean(maLoai, tenLoai));
    		                url = "/admin/QuanLyLoai.jsp";
		                }
		                else {
		                    url = "/admin/ThemLoai.jsp";
		                }
		                break;
		            case "sua":
		                if(maLoaiErr.length() == 0 && tenLoaiErr.length() == 0) {
		                    loaiSach.suaLoai(new LoaiBean(maLoai,tenLoai));
		                    url = "/admin/QuanLyLoai.jsp";
		                }
		                else {
		                    url = "/admin/SuaLoai.jsp";
		                }
                        break;
		        }
		  
		}catch(Exception e) {
		    
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
