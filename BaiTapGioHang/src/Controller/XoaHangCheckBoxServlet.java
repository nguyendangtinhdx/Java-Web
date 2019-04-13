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
 * Servlet implementation class XoaHangCheckBoxServlet
 */
@WebServlet("/XoaHangCheckBoxServlet")
public class XoaHangCheckBoxServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public XoaHangCheckBoxServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        GioHangBO gio = (GioHangBO) session.getAttribute("gh");
        
        String maHang = request.getParameter("btnSua");
        String tenHang = "";

        if (maHang != null) {
            int sl = Integer.parseInt(request.getParameter(maHang));
            if (session.getAttribute("gh") != null) {
                if (gio != null) {
                    gio.Add(maHang, tenHang, (long) 0, sl);
                }
            }
        } else {
            String[] value = request.getParameterValues("chon");
            if (value != null) {
                if (session.getAttribute("gh") != null) {
                    if (gio != null) {
                        int n = value.length;
                        for (int i = 0; i < n; i++)
                            gio.Remove(value[i]);
                    }
                }
            }

        }
        session.setAttribute("gh", gio);
        response.sendRedirect("HienThiGio.jsp");
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
