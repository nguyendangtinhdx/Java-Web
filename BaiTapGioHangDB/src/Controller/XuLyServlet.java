package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.LoaiBo;
import Bo.SachBo;
@WebServlet("/XuLyServlet")
public class XuLyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XuLyServlet() {
        super();
    }
    LoaiBo loai = new LoaiBo();
    SachBo sach = new SachBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // chuyển mã utf-8 về client
	    response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");
	    // lấy tất cả loai từ Bo lưu vào biến request: dsloai
	    request.setAttribute("dsloai", loai.getLoai());
	    String maLoai = request.getParameter("ml");
	    String key = request.getParameter("key");
	    if(maLoai != null) {
	        request.setAttribute("dssach", sach.getSachByLoai(maLoai));
	    }
	    else if(key != null) {
	        request.setAttribute("dssach", sach.TimKiem(key));
	    }
	    else {
	        request.setAttribute("dssach", sach.getSach());
	    }
        
        RequestDispatcher rd = request.getRequestDispatcher("index2.jsp");
        rd.forward(request, response);
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
