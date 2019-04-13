package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.ChiTietDotUngHoBO;
import bo.DonViUngHoBO;
import bo.DotNhanUngHoBO;
import bo.DotUngHoBO;
import bo.ThongKeBO;

@WebServlet("/XuLyServlet")
public class XuLyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XuLyServlet() {
        super();
    }
    DotNhanUngHoBO dotNhanUngHo = new DotNhanUngHoBO();
    ThongKeBO thongKe = new ThongKeBO();
    DonViUngHoBO donViUngHo = new DonViUngHoBO();
    DotUngHoBO dotUngHo = new DotUngHoBO();
    ChiTietDotUngHoBO chiTietDotUngHo = new ChiTietDotUngHoBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setCharacterEncoding("utf-8");
       request.setCharacterEncoding("utf-8");
	   String url = "index.jsp";
	   
	   String tk = request.getParameter("tk");
	   String listDotUngHo = request.getParameter("dotUngHo");
	   String listChiTietDotUngHo = request.getParameter("chiTietDotUngHo");
	   String addDotUngHo = request.getParameter("addDotUngHo");
       String editDotUngHo = request.getParameter("editDotUngHo");
	   String addChiTietDotUngHo = request.getParameter("addChiTietDotUngHo");
	   String editChiTietDotUngHo = request.getParameter("editChiTietDotUngHo");
	   if(listDotUngHo != null) {
	       url = "DotUngHo.jsp";
	   }
	   if(listChiTietDotUngHo != null) {
           url = "ChiTietDotUngHo.jsp";
       }
	   if(tk != null) {
	       url = "ThongKe.jsp";
	   }
	   if(addDotUngHo != null ) {
	       url = "ThemDotUngHo.jsp";
	   }
	   if(editDotUngHo != null ) {
           url = "SuaDotUngHo.jsp";
       }
	   if(addChiTietDotUngHo != null ) {
	       url = "ThemChiTietDotUngHo.jsp";
	   }
	   if(editChiTietDotUngHo != null) {
	       url = "SuaChiTietDotUngHo.jsp";
	   }
	   
	   request.setAttribute("ListDotUngHo", dotUngHo.getListDotUngHo());
	   request.setAttribute("ListChiTietDotUngHo", chiTietDotUngHo.getListChiTietDotUngHo());
       request.setAttribute("ListDotNhanUngHo", dotNhanUngHo.getListDotNhanUngHo());
       request.setAttribute("ListThongKe", thongKe.getListThongKe());
       request.setAttribute("ListDonViUngHo", donViUngHo.getListDonViUngHo());
       
       RequestDispatcher rd = request.getRequestDispatcher(url);
       rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
