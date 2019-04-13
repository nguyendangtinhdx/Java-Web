package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.GioHangBO;


@WebServlet("/XoaHangServlet")
public class XoaHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XoaHangServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*    HttpSession session = request.getSession();
		GioHangBO gio = new GioHangBO();
		String maHang = request.getParameter("mh");
		gio = (GioHangBO)session.getAttribute("gh");
		gio.Remove(maHang);
		session.setAttribute("gh", gio);
		response.sendRedirect("HienThiGio.jsp");*/
	    
	 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
