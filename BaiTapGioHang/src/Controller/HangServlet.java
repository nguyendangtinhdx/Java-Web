package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.HangBO;
import Bean.HangBean;

@WebServlet("/HangServlet")
public class HangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HangServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/* request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");*/
	        
		// lấy dữ liệu từ BO;
		HangBO hang = new HangBO();
		ArrayList<HangBean> dsHang = hang.getHang();
		request.setAttribute("dsHang", dsHang);
		// chuyển dữ liệu về trang Hang.jsp
		RequestDispatcher rd = request.getRequestDispatcher("Hang.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
