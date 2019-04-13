package com.tinhnd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tinhnd.bean.MayBEAN;
import com.tinhnd.bo.MayBO;

@WebServlet("/MayServlet")
public class MayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MayServlet() {
        super();
    }

    MayBO mayBo = new MayBO();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String loai = request.getParameter("loai");
        String mm = request.getParameter("maMay");
        if(loai.equals("xoaMay")) {
            mayBo.xoaMay(mm);
            response.sendRedirect("MainServlet?danhSachMay=1");
        }
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String url = "MainServlet?danhSachMay=1";

        String loai = request.getParameter("loai");

        String mm = request.getParameter("maMay");
        String vt = request.getParameter("viTri");
        String tt = request.getParameter("trangThai");

        String mmE = "", vtE = "", ttE="";
//        if(mm.equals("")) {
//            mmE = "Mã máy không được để trống";
//            request.setAttribute("mmE", mmE);
//        }
        if (mayBo.checkMaMay(mm)) {
            mmE = "Mã máy đã tồn tại";
            request.setAttribute("mmE", mmE);
        }
        if(vt.equals("")) {
            vtE = "Vị trí không được để trống";
            request.setAttribute("vtE", vtE);
        }

        if (loai.equals("them")) {
            if(mmE.length() == 0 && vtE.length() == 0 )
            {
                MayBEAN m = new MayBEAN();
                m.setMaMay(mm);
                m.setViTri(vt);
                m.setTrangThai(tt);

                mayBo.themMay(m);
            }else {
                url = "MainServlet?themMay=1";
            }
        }
        if (loai.equals("sua")) {
            if(vtE.length() == 0)
            {
                mayBo.suaMay(new MayBEAN(mm, vt, tt));
            }else {
                url = "MainServlet?suaMay=1";
            }
        } 
        
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);

    }

}
