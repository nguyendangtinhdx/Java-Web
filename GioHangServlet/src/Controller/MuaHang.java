package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.GioHangBo;

/**
 * Servlet implementation class MuaHang
 */
@WebServlet("/MuaHang")
public class MuaHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MuaHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String mhang = request.getParameter("mh");
			String thang = request.getParameter("th");
			Long gia = Long.parseLong(request.getParameter("g"));
			GioHangBo gio;
			// tao ra doi tuong sesion
			HttpSession session = request.getSession();
			if(session.getAttribute("gh")==null)//neu mua lan dau
			{
				gio = new GioHangBo();//tao ra gio
				session.setAttribute("gh", gio);//luu vao session
			}//lay session luu vao gio
			gio = (GioHangBo)session.getAttribute("gh");
			gio.them(mhang,thang,gia,(long)1);//them hang vao gio
			session.setAttribute("gh", gio);//luu gio vao session
			response.sendRedirect("HienThiGio.jsp");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
