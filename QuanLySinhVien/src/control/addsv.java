package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.sinhvien;

/**
 * Servlet implementation class addsv
 */
@WebServlet("/addsv")
public class addsv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addsv() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // mã hóa để lấy được tiếng việt
		if (request.getParameter("dk") != null) { // kiểm tra nếu được nhận
			// lấy ra các trường thông tin
			String ht = request.getParameter("ht");
			String lop = request.getParameter("lop");
			String gioitinh = request.getParameter("gt");
			int cn = Integer.parseInt(request.getParameter("cn"));
		
			sinhvien sv = new sinhvien();
			sv.setHoten(ht);
			sv.setLop(lop);
			sv.setGioitinh(gioitinh);
			sv.setChuyennganh(cn);;
			 
			if (sv.addsv()) {// kiểm tra có thêm thành công
				// chuyển sang trang nhập điểm sinh viên
				response.sendRedirect("nhapdiem.jsp");
			}
			else{
				response.sendRedirect("themsv.jsp");
			}
		}
	}
}
