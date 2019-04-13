package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.HangBo;
import Bo.MayTinhBo;

@WebServlet("/XuLyServlet")
public class XuLyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public XuLyServlet() {
        super();
    }

    HangBo hang = new HangBo();
    MayTinhBo maytinh = new MayTinhBo();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String url = "index.jsp";
        
        String maHang = request.getParameter("mh");
        String key = request.getParameter("key");
        if(maHang != null) {
            request.setAttribute("List", maytinh.getListMayTinhByHang(maHang));
        }
        else if(key != null) {
            request.setAttribute("List", maytinh.getListMayTinhByKey(key));
        }

        
        request.setAttribute("ListHang", hang.getListHang());

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
