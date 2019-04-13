package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.SachBo;

@WebServlet("/SachServlet")
public class SachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SachServlet() {
        super();
    }
    SachBo sach = new SachBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       response.setCharacterEncoding("utf-8");
	       String maLoai = request.getParameter("ml");
	        if(maLoai != null) {
	            request.setAttribute("dssach", sach.getSachByLoai(maLoai));
	        }
	        PrintWriter out = response.getWriter();
	        out.print("<i> Mã loại là: "+ maLoai+"</i>");
	        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
