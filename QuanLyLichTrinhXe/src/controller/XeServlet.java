package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.XeBEAN;
import bo.XeBO;

@WebServlet("/XeServlet")
public class XeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XeServlet() {
        super();
    }
    XeBO xeBO = new XeBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String url = "MainServlet";

        String loai = request.getParameter("loai");

        String maXe = request.getParameter("maXe");
        String hangSanXuat = request.getParameter("hangSanXuat");
        String maLoaiXe = request.getParameter("maLoaiXe");
        String bienSo = request.getParameter("bienSo");
        String hkd = request.getParameter("hanKiemDinh");
        String maNhaXe = request.getParameter("maNhaXe");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date hanKiemDinh = null;
        Date dayNow;
        try {
            hanKiemDinh = df.parse(hkd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String s[] = hkd.split("[-]");
        
        if (loai.equals("them")) {
//            if(Integer.parseInt(s[1]) < 1900) {
//                request.setAttribute("errorHanKiemDinh", "Hạn kiểm định không đúng, hạn kiểm định phải > thời gian hiện tại là 1 tháng, xin nhập lại thông tin hạn kiểm định !");
//                url = "MainServlet?themXe=1";
//            }else {
                xeBO.themXe(new XeBEAN(maXe, hangSanXuat, maLoaiXe, bienSo, hanKiemDinh, maNhaXe));
                url = "MainServlet?danhSachXe=1";
//            }
        }

        
        
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
        
	}

}
