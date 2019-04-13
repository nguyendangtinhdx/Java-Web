package BO;

import java.util.ArrayList;

import Bean.HangBean;
import DAO.HangDAO;

public class HangBO {
    HangDAO hang = new HangDAO();
    public ArrayList<HangBean> getHang(){
        return hang.getHang();
    }
}
