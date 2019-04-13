package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.sinhvien;

/**
 * Servlet implementation class getDS
 */
@WebServlet("/getDS")
public class getDS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getDS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
	
		sinhvien sv = new sinhvien();
		Vector<sinhvien> vtsv = sv.listSV();
		RequestDispatcher rsd = request.getRequestDispatcher("nhapdiem.jsp");
		request.setAttribute("listsv", vtsv); // truyền từ đối tượng 
		rsd.forward(request, response);// gửi vtsv sang file nhapdiem.jsp
	}

}
