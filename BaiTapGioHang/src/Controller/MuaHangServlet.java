package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.GioHangBO;

/**
 * Servlet implementation class MuaHangServlet
 */
@WebServlet("/MuaHangServlet")
public class MuaHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MuaHangServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mahang = request.getParameter("mh");
		String tenhang = request.getParameter("th");
		long gia = Long.parseLong(request.getParameter("gia"));
/*		response.getWriter().print(mahang + " : " + tenhang +" : " + gia );*/
		GioHangBO gio ;
		// tạo ra đối tượng session
		HttpSession session = request.getSession();
		if(session.getAttribute("gh") == null) {
		    gio = new GioHangBO();
		    session.setAttribute("gh", gio);
		}
		gio = (GioHangBO)session.getAttribute("gh");
		gio.Add(mahang, tenhang, (long)gia, 1);
		session.setAttribute("gh", gio);
		
		response.sendRedirect("HienThiGio.jsp");
	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
