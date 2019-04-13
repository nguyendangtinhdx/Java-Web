package com.tinhnd.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tinhnd.bean.DangKyBEAN;
import com.tinhnd.bean.DichVuBEAN;
import com.tinhnd.bean.KhachHangBEAN;
import com.tinhnd.bean.MayBEAN;
import com.tinhnd.bo.DangKyBO;
import com.tinhnd.bo.DichVuBO;
import com.tinhnd.bo.KhachHangBO;
import com.tinhnd.bo.MayBO;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MainServlet() {
        super();
    }

    MayBO mayBo = new MayBO();
    KhachHangBO khachHangBO = new KhachHangBO();
    DichVuBO dichVuBO = new DichVuBO();
    DangKyBO dangKyBO = new DangKyBO();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        
        String url = "index.jsp";
        String listMay = request.getParameter("danhSachMay");
        String addMay = request.getParameter("themMay");
        String editMay = request.getParameter("suaMay");
        String listKhachHang = request.getParameter("danhSachKhachHang");
        String addKhachHang = request.getParameter("themKhachHang");
        String editKhachHang = request.getParameter("suaKH");
        String listDichVu = request.getParameter("danhSachDichVu");
        String addDichVu = request.getParameter("themDichVu");
        String editDichVu = request.getParameter("suaDV");
        String addSuDungMay = request.getParameter("themSuDungMay");
        String listDangKy = request.getParameter("danhSachDangKy");
        String addSuDungDichVu = request.getParameter("themSuDungDichVu");
        
        
        
        String loai = request.getParameter("loai");
        String keyMay = request.getParameter("keyMay");
        String keyKhachHang = request.getParameter("keyKhachHang");
        String keyDichVu = request.getParameter("keyDichVu");
        
        int pages = 5;
        request.setAttribute("ListMay", mayBo.getListMay());
        if(listMay != null) {
            url = "DanhSachMay.jsp";
            
            ArrayList<MayBEAN> arrListMay = mayBo.getListMay();
            int start = 0, end = pages;
            if (arrListMay.size() < pages) {
                end = arrListMay.size();
            }
            if (request.getParameter("start") != null) {
                start = Integer.parseInt(request.getParameter("start"));
            }
            if (request.getParameter("end") != null) {
                end = Integer.parseInt(request.getParameter("end"));
            }
            request.setAttribute("ListMayByPage", mayBo.getListMayByPage(arrListMay, start, end));
        }
        if(addMay != null) {
            url = "ThemMay.jsp";
        }
        if(editMay != null) {
            url = "SuaMay.jsp";
        }
        request.setAttribute("ListKhachHang", khachHangBO.getListKhachHang());
        if(listKhachHang != null) {
            url = "DanhSachKhachHang.jsp";
            
            ArrayList<KhachHangBEAN> arrListKhachHang = khachHangBO.getListKhachHang();
            int start = 0, end = pages;
            if (arrListKhachHang.size() < pages) {
                end = arrListKhachHang.size();
            }
            if (request.getParameter("start") != null) {
                start = Integer.parseInt(request.getParameter("start"));
            }
            if (request.getParameter("end") != null) {
                end = Integer.parseInt(request.getParameter("end"));
            }
            request.setAttribute("ListKhachHangByPage", khachHangBO.getListKhachHangByPage(arrListKhachHang, start, end));
        }
        if(addKhachHang != null) {
            url = "ThemKhachHang.jsp";
        }
        if(editKhachHang != null) {
            url = "SuaKhachHang.jsp";
        }
        request.setAttribute("ListDichVu", dichVuBO.getListDichVu());
        if(listDichVu != null) {
            url = "DanhSachDichVu.jsp";
            
            ArrayList<DichVuBEAN> arrListDichVu = dichVuBO.getListDichVu();
            int start = 0, end = pages;
            if (arrListDichVu.size() < pages) {
                end = arrListDichVu.size();
            }
            if (request.getParameter("start") != null) {
                start = Integer.parseInt(request.getParameter("start"));
            }
            if (request.getParameter("end") != null) {
                end = Integer.parseInt(request.getParameter("end"));
            }
            request.setAttribute("ListDichVuByPage", dichVuBO.getListDichVuByPage(arrListDichVu, start, end));
        }
        if(addDichVu != null) {
            url = "ThemDichVu.jsp";
        }
        if(editDichVu != null) {
            url = "SuaDichVu.jsp";
        }
        if(keyMay != null) {
            if(loai.equals("timKiemMay")) {
//                request.setAttribute("ListMay", mayBo.timKiemMay(keyMay));
                
                ArrayList<MayBEAN> arrListMayBySearch = mayBo.timKiemMay(keyMay);
                int start = 0, end = pages;
                if (arrListMayBySearch.size() < pages) {
                    end = arrListMayBySearch.size();
                }
                if (request.getParameter("start") != null) {
                    start = Integer.parseInt(request.getParameter("start"));
                }
                if (request.getParameter("end") != null) {
                    end = Integer.parseInt(request.getParameter("end"));
                }
                request.setAttribute("ListMayByPage", mayBo.getListMayByPage(arrListMayBySearch, start, end));
                
                url = "DanhSachMay.jsp";
            }
        }
        
        if(keyKhachHang != null) {
            if(loai.equals("timKiemKhachHang")) {
//              request.setAttribute("ListKhachHang", khachHangBO.timKiemKhachHang(keyKhachHang));
                ArrayList<KhachHangBEAN> arrListKhachHangBySearch = khachHangBO.timKiemKhachHang(keyKhachHang);
                int start = 0, end = pages;
                if (arrListKhachHangBySearch.size() < pages) {
                    end = arrListKhachHangBySearch.size();
                }
                if (request.getParameter("start") != null) {
                    start = Integer.parseInt(request.getParameter("start"));
                }
                if (request.getParameter("end") != null) {
                    end = Integer.parseInt(request.getParameter("end"));
                }
                request.setAttribute("ListKhachHangByPage", khachHangBO.getListKhachHangByPage(arrListKhachHangBySearch, start, end));
                
                url = "DanhSachKhachHang.jsp";
            }
        }
        if(keyDichVu != null) {
            if(loai.equals("timKiemDichVu")) {
//                request.setAttribute("ListDichVu", dichVuBO.timKiemDichVu(keyDichVu));
                
                ArrayList<DichVuBEAN> arrListDichVuBySearch = dichVuBO.timKiemDichVu(keyDichVu);
                int start = 0, end = pages;
                if (arrListDichVuBySearch.size() < pages) {
                    end = arrListDichVuBySearch.size();
                }
                if (request.getParameter("start") != null) {
                    start = Integer.parseInt(request.getParameter("start"));
                }
                if (request.getParameter("end") != null) {
                    end = Integer.parseInt(request.getParameter("end"));
                }
                request.setAttribute("ListDichVuByPage", dichVuBO.getListDichVuByPage(arrListDichVuBySearch, start, end));
                
                url = "DanhSachDichVu.jsp";
            }
        }
        request.setAttribute("ListDangKy", dangKyBO.getListDangKy());
        if(listDangKy != null) {
            url = "DanhSachDangKy.jsp";
            ArrayList<DangKyBEAN> arrListDangKy= dangKyBO.getListDangKy();
            int start = 0, end = pages;
            if (arrListDangKy.size() < pages) {
                end = arrListDangKy.size();
            }
            if (request.getParameter("start") != null) {
                start = Integer.parseInt(request.getParameter("start"));
            }
            if (request.getParameter("end") != null) {
                end = Integer.parseInt(request.getParameter("end"));
            }
            request.setAttribute("ListDangKyByPage", dangKyBO.getListDangKyByPage(arrListDangKy, start, end));
        }
        if(addSuDungMay!= null) {
            url = "ThemSuDungMay.jsp";
        }
        if(addSuDungDichVu!= null) {
            url = "ThemSuDungDichVu.jsp";
        }
        
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
