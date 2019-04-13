package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.GioHangBO;
import Bean.GioHangBean;

/**
 * Servlet implementation class SuaHangServlet
 */
@WebServlet("/SuaHangServlet")
public class SuaHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SuaHangServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String maHang = request.getParameter("mh");
	    String tenHang = "";
	    int sl = Integer.parseInt(request.getParameter("txtSoLuong"));
	    GioHangBO gio = new GioHangBO();
	    HttpSession session = request.getSession();
	    gio = (GioHangBO)session.getAttribute("gh");
	    gio.Add(maHang, tenHang, (long)0, sl);
	    session.setAttribute("gh", gio);
	    response.sendRedirect("HienThiGio.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
