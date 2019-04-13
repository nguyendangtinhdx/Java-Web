package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // tạo đối tượng out
		PrintWriter out = response.getWriter();
		out.print("<body> hello </body>");
		String ts = request.getParameter("ts");
		long a = Long.parseLong(request.getParameter("txta"));
		long b = Long.parseLong(request.getParameter("txtb"));
		long kq = a + b;
		
//	*
//		response.sendRedirect("TestServlet.jsp?kq=" + kq); // truyền cách 1
		
		HttpSession session = request.getSession();
		session.setAttribute("kq", kq); // truyền cách 2
		
		request.setAttribute("kq",kq);  // truyền cách 3
		RequestDispatcher rd =  request.getRequestDispatcher("TestServlet.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
