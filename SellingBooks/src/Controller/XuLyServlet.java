package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.KhachHangBean;
import Bean.SachBean;
import Bo.KhachHangBo;
import Bo.LoaiBo;
import Bo.SachBo;
import Bo.ThongKeHoaDonBo;

@WebServlet("/XuLyServlet")
public class XuLyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XuLyServlet() {
        super();
    }
    LoaiBo loai = new LoaiBo();
    SachBo sach = new SachBo();
    KhachHangBo khachhang = new KhachHangBo();
    ThongKeHoaDonBo hoadon = new ThongKeHoaDonBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String url = "index.jsp";
        
        String maLoai = request.getParameter("maLoai") ;
        String maSach = request.getParameter("maSach");
        String key = request.getParameter("key");
        if (maLoai != null) {
           request.setAttribute("ListSachByLoai", sach.getListSachByLoai(maLoai));
           ArrayList<SachBean> arr = sach.getListSachByLoai(maLoai);
           int pages = 6;
           int start = 0, end = pages;
           if (arr.size() < pages) {
               end = arr.size();
           }
           if (request.getParameter("start") != null) {
               start = Integer.parseInt(request.getParameter("start"));
           }
           if (request.getParameter("end") != null) {
               end = Integer.parseInt(request.getParameter("end"));
           }
           request.setAttribute("ListSachByPage", sach.getListSachByPage(arr, start, end));
           
           request.setAttribute("ListSachByLoaiMoiNhat", sach.getListSachByLoaiMoiNhat(maLoai));
           url = "product.jsp";
        }
        if(maSach != null) {
            request.setAttribute("Sach", sach.getSach(maSach));
            request.setAttribute("ListSachMoiNhat", sach.getListSachMoiNhat(maLoai, maSach));
            request.setAttribute("ListSachLienQuan", sach.getListSachLienQuan(maLoai, maSach));
            request.setAttribute("ListSachLienQuan2", sach.getListSachLienQuan2(maLoai, maSach));
            url = "detail.jsp";
        }
        if(key != null) {
            request.setAttribute("TimKiem", sach.TimKiem(key));
            url = "find.jsp";
        }
        String thongke = request.getParameter("thongke");
        if(thongke != null)
        {
            HttpSession session = request.getSession();
            KhachHangBean kh = null;
            if(session.getAttribute("tendangnhap") != null){
                 kh = (KhachHangBean)session.getAttribute("tendangnhap");
            }
            request.setAttribute("ListThongKeHoaDon", hoadon.getListThongKeHoaDon(kh.getTenDangNhap()));
            url = "thongke.jsp";
        }
        
        String news = request.getParameter("news");
        if(news != null)
        {
            url = "news.jsp";
        }
        String help = request.getParameter("help");
        if(help != null)
        {
            url = "help.jsp";
        }
        String contact = request.getParameter("contact");
        if(contact != null)
        {
            url = "contact.jsp";
        }
        
        request.setAttribute("ListSachMoiNhatTrangChu", sach.getListSachMoiNhatTrangChu());
        request.setAttribute("ListSachGiaRe", sach.getListSachGiaRe());
        request.setAttribute("ListSachKhoaHoc", sach.getListSachKhoaHoc());
        request.setAttribute("ListSachToanHoc", sach.getListSachToanHoc());
        request.setAttribute("ListLoai", loai.getListLoai());
        request.setAttribute("ListLoaiTuNhien", loai.getListLoaiTuNhien());
        request.setAttribute("ListLoaiXaHoi", loai.getListLoaiXaHoi());
      
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
