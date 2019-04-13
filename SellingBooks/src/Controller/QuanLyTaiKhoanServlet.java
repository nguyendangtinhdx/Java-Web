package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.AdminBean;
import Bo.AdminBo;
import Tools.MD5;

@WebServlet("/QuanLyTaiKhoanServlet")
public class QuanLyTaiKhoanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public QuanLyTaiKhoanServlet() {
        super();
    }

    AdminBo adminBo = new AdminBo();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String loai = request.getParameter("loai");
        String tenDangNhap = request.getParameter("tenDangNhap");
        try {
            if(loai.equals("xoa")) {
                adminBo.xoaTaiKhoan(tenDangNhap);
                response.sendRedirect("/SellingBooks/admin/QuanLyTaiKhoan.jsp");
            }

        } catch (Exception e) {

        }
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String loai = request.getParameter("loai");
        String tenDangNhap = request.getParameter("tenDangNhap");
        String matKhau = request.getParameter("matKhau");
        String q = request.getParameter("quyen");
        int quyen = 0;
        if (q.equals("true")) {
            quyen = 1;
        }

        String url = "";
        String tenDangNhapErr = "", matKhauErr = "";
        if (tenDangNhap.equals("")) {
            tenDangNhapErr = "Vui lòng nhập tên tài khoản";
            request.setAttribute("tenDangNhapErr", tenDangNhapErr);
        }
        if (matKhau.equals("")) {
            matKhauErr = "Vui lòng nhập mật khẩu";
            request.setAttribute("matKhauErr", matKhauErr);
        }
        try {
            switch (loai) {
            case "them":
                if (tenDangNhapErr.length() == 0 && matKhauErr.length() == 0) {
                    adminBo.themTaiKhoan(new AdminBean(tenDangNhap,
                            MD5.MaHoa(matKhau), quyen));
                    url = "/admin/QuanLyTaiKhoan.jsp";
                } else {
                    url = "/admin/ThemTaiKhoan.jsp";
                }
                break;
            case "sua":
                if (tenDangNhapErr.length() == 0 && matKhauErr.length() == 0) {
                    adminBo.suaTaiKhoan(new AdminBean(tenDangNhap,
                            MD5.MaHoa(matKhau), quyen));
                    url = "/admin/QuanLyTaiKhoan.jsp";
                } else {
                    url = "/admin/SuaTaiKhoan.jsp";
                }
            }

        } catch (Exception e) {

        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

}
