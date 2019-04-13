package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.KhachHangBean;
import Bo.KhachHangBo;
import Captcha.VerifyRecaptcha;
import Tools.MD5;

@WebServlet("/KhachHangServlet")
public class KhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public KhachHangServlet() {
        super();
    }

    KhachHangBo khachhang = new KhachHangBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        if(request.getParameter("loai").equals("dangxuat")){
            HttpSession session = request.getSession();
            session.invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("XuLyServlet");
            rd.forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession();
		KhachHangBean kh = new KhachHangBean();
		
		String loai = request.getParameter("loai");
        String url = "";
       /* Long maKhachHang = new  java.util.Date().getTime();*/
        String hoTen = request.getParameter("hoten");
        String diaChi = request.getParameter("diachi");
        String sdt = request.getParameter("sdt");
        String email= request.getParameter("email");
        String tenDangNhap = request.getParameter("tendangnhap");
        String matKhau = request.getParameter("matkhau");
        
        String hoTenErr = "", diaChiErr = "", sdtErr = "", emailErr = "", tenDangNhapErr = "", matKhauErr = "";
        
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
        
        switch(loai) {
            case "dangky":
                
                if(hoTen.equals("")) {
                    hoTenErr = "Vui lòng nhập họ tên";
                }
                if(hoTenErr.length() > 0){
                    request.setAttribute("hoTenErr", hoTenErr);
                }
                if(diaChi.equals("")) {
                    diaChiErr = "Vui lòng nhập địa chỉ";
                }
                if(diaChiErr.length() > 0){
                    request.setAttribute("diaChiErr", diaChiErr);
                }
                if(sdt.equals("")) {
                    sdtErr = "Vui lòng nhập số điện thoại";
                }
                if(sdtErr.length() > 0){
                    request.setAttribute("sdtErr", sdtErr);
                }
                if(email.equals("")) {
                    emailErr = "Vui lòng nhập Email";
                }
                if(emailErr.length() > 0){
                    request.setAttribute("emailErr", emailErr);
                }
                if(tenDangNhap.equals("")) {
                    tenDangNhapErr = "Vui lòng nhập tên đăng nhập";
                }
                else {
                    if(khachhang.checkTaiKhoan(tenDangNhap) == true){
                        tenDangNhapErr = "Tên đăng nhập đã được đăng ký";
                    }
                }
                if(tenDangNhapErr.length() > 0){
                    request.setAttribute("tenDangNhapErr", tenDangNhapErr);
                }
                if(matKhau.equals("")) {
                    matKhauErr = "Vui lòng nhập mật khẩu";
                }
                if(matKhauErr.length() > 0){
                    request.setAttribute("matKhauErr", matKhauErr);
                }
                    
                /*kh.setMaKhachHang(maKhachHang);*/
                kh.setHoTen(hoTen);
                kh.setDiaChi(diaChi);
                kh.setSdt(sdt);
                kh.setEmail(email);
                kh.setTenDangNhap(tenDangNhap);
                kh.setMatKhau(MD5.MaHoa(matKhau));
                
                if(hoTenErr.length() == 0 && diaChiErr.length() == 0 && sdtErr.length() == 0 && emailErr.length() == 0 && tenDangNhapErr.length() == 0 && matKhauErr.length() == 0 )
                {
                    khachhang.dangKy(kh);
                    request.setAttribute("signupsuccess", "Đăng ký tài khoản thành công");
                }
                
                url = "account.jsp";
                break;
            case "dangnhap":
                kh =  khachhang.dangNhap(tenDangNhap, MD5.MaHoa(matKhau));
                if(kh != null) {
                    if (verify) {
                        session.setAttribute("tendangnhap", kh);
                        request.setAttribute("loginsuccess", "Đăng nhập thành công");
                        url = "XuLyServlet";
                    }
                    else {
                        request.setAttribute("CaptchaErrKhachHang", "Bạn chưa xác nhận Captcha");
                        url = "account.jsp";
                    }
                }
                else {
                    request.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
                    url = "account.jsp";
                }
                break;
                
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

}
