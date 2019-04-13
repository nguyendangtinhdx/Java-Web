//package controller;
//
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import bean.CongDanBEAN;
//
//@WebServlet("/HoKhauServlet")
//public class HoKhauServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    public HoKhauServlet() {
//        super();
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	    response.setCharacterEncoding("utf-8");
//        request.setCharacterEncoding("utf-8");
//        String url = "XuLyServlet";
//       
//        String loai = request.getParameter("loai");
//        
//        
//        String cmndID = request.getParameter("cmndID");
//        String ten = request.getParameter("ten");
//        String ho = request.getParameter("ho");
//        String ns = request.getParameter("ngaySinh");
//        String gt = request.getParameter("gioiTinh");
//        String noiSinh = request.getParameter("noiSinh");
//        String tinhTrangHonNhan = request.getParameter("tinhTrangHonNhan");
//        String ngheNghiep = request.getParameter("ngheNghiep");
//        long gioiTinh = 0;
//        if(gt.equals("Nam"))
//        {
//            gioiTinh = 1;
//        }else
//        {
//            gioiTinh = 0;
//        }
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        Date ngaySinh = null;
//        try {
//            ngaySinh =  df.parse(ns);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        String cmndIDE = "", tenE = "", hoE = "",ngaySinhE= "" ,noiSinhE = "", tinhTrangHonNhanE = "", ngheNghiepE="";
//        if(cmndID.equals("")) {
//            cmndIDE = "Vui lòng nhập số CMND";
//            request.setAttribute("cmndIDE", cmndIDE);
//        }
//        else {
//            if(congDan.checkMa(cmndID)) {
//                cmndIDE = "Số CMND đã tồn tại";
//                request.setAttribute("cmndIDE", cmndIDE);
//            }
//        }
//        if(ten.equals("")) {
//            tenE = "Vui lòng nhập tên";
//            request.setAttribute("tenE", tenE);
//        }
//        if(ho.equals("")) {
//            hoE = "Vui lòng nhập họ";
//            request.setAttribute("hoE", hoE);
//        }
////      Date ngayHienTai = new Date(new Date().getTime());
////      Date nht = null;
////        try {
////            nht =  df.parse(ngayHienTai);
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
////      if(ns.equals("")) {
////          ngaySinhE = "Vui lòng nhập ngày sinh";
////          request.setAttribute("ngaySinhE", ngaySinhE);
////      }
////      else {
////          if(ngaySinh < ngayHienTai)
////      }
//        if(noiSinh.equals("")) {
//            noiSinhE = "Vui lòng nhập nơi sinh";
//            request.setAttribute("noiSinhE", noiSinhE);
//        }
//        if(tinhTrangHonNhan.equals("")) {
//            tinhTrangHonNhanE = "Vui lòng nhập tình trạng hôn nhân";
//            request.setAttribute("tinhTrangHonNhanE", tinhTrangHonNhanE);
//        }
//        if(ngheNghiep.equals("")) {
//            ngheNghiepE = "Vui lòng nhập nghề nghiệp";
//            request.setAttribute("ngheNghiepE", ngheNghiepE);
//        }
//    
//
//        if(loai.equals("them")) {
//            if(cmndIDE.length() == 0 && hoE.length() == 0 && tenE.length() == 0 && ngaySinhE.length() == 0 && noiSinhE.length() == 0 && tinhTrangHonNhanE.length() == 0 && ngheNghiepE.length() == 0) {
//                CongDanBEAN cd = new CongDanBEAN();
//                cd.setCmndID(cmndID);
//                cd.setTen(ten);
//                cd.setHo(ho);
//                cd.setNgaySinh(ngaySinh);
//                cd.setGioiTinh(gioiTinh);
//                cd.setNoiSinh(noiSinh);
//                cd.setTinhTrangHonNhan(tinhTrangHonNhan);
//                cd.setNgheNghiep(ngheNghiep);
//
//                congDan.themCongDan(cd);
//                url = "XuLyServlet?quanLyCongDan=1";
//            }
//            else {
//               url = "XuLyServlet?add=1";
//            }
//        }
//        
//   /*    if(loai.equals("sua")) {
//           if(ldhhd.equals("")) {
//               ldhhdE = "Vui lòng nhập lý do hủy hoạt động";
//               request.setAttribute("ldhhdE", ldhhdE);
//           }
//           if(thdE.length() == 0 && mthdE.length() == 0 && ngbdE.length() == 0 && ngbdE.length() == 0 && thdkE.length() == 0 && ldhhdE.length() == 0) {
//               hoatDong.suaHoatDong(new HoatDongBEAN(mhd, thd, mthd, ngbd, ngkt, (long)sltt, (long)sltd, thdk, tt, mtv, ldhhd));
//           }
//           else {
//               url = "XuLyServlet?edit=1";
//           }
//       }*/
//        
//        
//        
//        RequestDispatcher rd = request.getRequestDispatcher(url);
//        rd.forward(request, response);
//	}
//
//}
