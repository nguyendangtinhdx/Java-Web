package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.LoaiXeBO;
import bo.NhaXeBO;
import bo.TongTienBO;
import bo.TuyenXeBO;
import bo.XeBO;
import bo.XeDangKyBO;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
    }
    XeDangKyBO xeDangKyBO = new XeDangKyBO();
    LoaiXeBO loaiXeBO = new LoaiXeBO();
    NhaXeBO nhaXeBO = new NhaXeBO();
    XeBO xeBO = new XeBO();
    TuyenXeBO tuyenXeBO = new TuyenXeBO();
    TongTienBO tongTienBO = new TongTienBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String url = "index.jsp";
        
        String loai = request.getParameter("loai");

        String danhSachXeDangKy = request.getParameter("danhSachXeDangKy");
        String themXe = request.getParameter("themXe");
        String themLichTrinhXe = request.getParameter("themLichTrinhXe");
        String danhSachTongTien= request.getParameter("danhSachTongTien");
        String danhSachXe= request.getParameter("danhSachXe");

        String keyXeDangKy = request.getParameter("keyXeDangKy");
        
        if(danhSachXeDangKy != null) {
            url="danhSachXeDangKy.jsp";
        }
        if(themXe != null) {
            url="themXe.jsp";
        }
        if(themLichTrinhXe != null) {
            url="themLichTrinhXe.jsp";
        }
        if(keyXeDangKy != null) {
            if(loai.equals("timKiemXeDangKy")) {
                request.setAttribute("ListXeDangKy", xeDangKyBO.getListXeDangKyByKey(keyXeDangKy));
                url="danhSachXeDangKy.jsp";
            }
        }else {
            request.setAttribute("ListXeDangKy", xeDangKyBO.getListXeDangKy());
        }
        if(danhSachXe != null) {
            url="danhSachXe.jsp";
        }
        if(danhSachTongTien != null) {
            url="danhSachTongTien.jsp";
        }
        
        request.setAttribute("ListLoaiXe", loaiXeBO.getListLoaiXe());
        request.setAttribute("ListNhaXe", nhaXeBO.getListNhaXe());
        request.setAttribute("ListXe", xeBO.getListXe());
        request.setAttribute("ListTuyenXe", tuyenXeBO.getListTuyenXe());
        request.setAttribute("ListTongTien", tongTienBO.getListTongTien());
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
