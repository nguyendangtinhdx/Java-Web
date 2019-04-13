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
 * Servlet implementation class ThaoTacGioHang
 */
@WebServlet("/ThaoTacGioHang")
public class ThaoTacGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThaoTacGioHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    GioHangBo gio = new GioHangBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cong = request.getParameter("butcong");
		String tru = request.getParameter("buttru");
	
		if(cong!=null)
		{String txtsua = request.getParameter(cong);
		    
			HttpSession session2 = request.getSession();
			if(session2.getAttribute("gh")!=null);
			{
				GioHangBo gio = (GioHangBo) session2.getAttribute("gh");
				if(gio!=null)
				{
					gio.cong(cong, txtsua);
					session2.setAttribute("gh", gio);
				}
				
			}//end 
		}
		else if(tru!=null)
		{	String txtsua = request.getParameter(tru);
			HttpSession session2 = request.getSession();
			if(session2.getAttribute("gh")!=null);
			{
				GioHangBo gio = (GioHangBo) session2.getAttribute("gh");
				if(gio!=null)
				{
					gio.tru(tru,txtsua);
					session2.setAttribute("gh", gio);
				}
				
			}//end 
		}
		else
		{
			String[] list = request.getParameterValues("kt");
			if(list!= null)
			{
				HttpSession session2 = request.getSession();
				if(session2.getAttribute("gh")!=null);
				{
					GioHangBo gio = (GioHangBo) session2.getAttribute("gh");
					if(gio!=null)
					{
						for(int i =0; i<list.length; i++)
							gio.Xoa(list[i]);
						session2.setAttribute("gh", gio);
					}
					
				}//end if session
			}//end if list
		}
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
