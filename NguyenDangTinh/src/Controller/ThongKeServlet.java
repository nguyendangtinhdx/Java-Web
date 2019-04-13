package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.ThongKeBo;

@WebServlet("/ThongKeServlet")
public class ThongKeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ThongKeServlet() {
        super();
    }
    ThongKeBo thongke = new ThongKeBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    request.setAttribute("ThongKe", thongke.getListThongKe());
	    
        RequestDispatcher rd = request.getRequestDispatcher("thongke.jsp");
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
