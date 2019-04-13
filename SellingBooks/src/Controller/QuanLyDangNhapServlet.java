package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.AdminBean;
import Bo.AdminBo;
import Captcha.VerifyRecaptcha;
import Tools.MD5;

@WebServlet("/QuanLyDangNhapServlet")
public class QuanLyDangNhapServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public QuanLyDangNhapServlet() {
        super();
    }

    AdminBo adminBo = new AdminBo();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        if (request.getParameter("loai").equals("dangxuat")) {
            HttpSession session = request.getSession();
            session.invalidate();
            RequestDispatcher rd = request
                    .getRequestDispatcher("/admin/login.jsp");
            rd.forward(request, response);
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

        String tenDangNhapErr = "", matKhauErr = "";
        if (tenDangNhap.equals("")) {
            tenDangNhapErr = "Vui lòng nhập tên đăng nhập";
            request.setAttribute("tenDangNhapErr", tenDangNhapErr);
        }
        if (matKhau.equals("")) {
            matKhauErr = "Vui lòng nhập mật khẩu";
            request.setAttribute("matKhauErr", matKhauErr);
        }
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
        
        String url = "";
        try {
            if (loai.equals("dangnhap")) {
                if (tenDangNhapErr.length() == 0 && matKhauErr.length() == 0) {
                    if (verify) {
                        HttpSession session = request.getSession();
                        AdminBean ad = new AdminBean();
                        ad = adminBo.dangNhap(tenDangNhap, MD5.MaHoa(matKhau));
                        if (ad != null) {
                            session.setAttribute("tendangnhap_admin", ad);
                            url = "/admin/index.jsp";
                        }
                    }
                    else {
                        request.setAttribute("CaptchaErr", "Bạn chưa xác nhận Captcha");
                        url = "/admin/login.jsp";
                    }
                } else {
                    url = "/admin/login.jsp";
                }
            }

        } catch (Exception e) {

        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

}
