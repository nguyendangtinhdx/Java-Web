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

import bean.LichTrinhXeBEAN;
import bo.XeDangKyBO;

@WebServlet("/LichTrinhXeServlet")
public class LichTrinhXeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LichTrinhXeServlet() {
        super();
    }
    XeDangKyBO xeDangKyBO = new XeDangKyBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String url = "MainServlet";

        String loai = request.getParameter("loai");

        String maXe = request.getParameter("maXe");
        String tenTaiXe = request.getParameter("tenTaiXe");
        String maTuyen = request.getParameter("maTuyen");
        String nxb = request.getParameter("ngayXuatBen");
        String gioXuatBen = request.getParameter("gioXuatBen");
        String slhk = request.getParameter("soLuongHanhKhach");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayXuatBen = null;
        try {
            ngayXuatBen = df.parse(nxb);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int soLuongHanhKhach = 1;
        if(slhk != null) {
            soLuongHanhKhach = Integer.parseInt(slhk);
        }

        
        if (loai.equals("them")) {
                xeDangKyBO.themLichTrinhXe(new LichTrinhXeBEAN(maXe, tenTaiXe, maTuyen, ngayXuatBen, gioXuatBen, soLuongHanhKhach));
                url = "MainServlet?danhSachXeDangKy=1";
        }
        
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
		
	}

}
