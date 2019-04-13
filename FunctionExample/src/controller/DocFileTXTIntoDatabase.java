package controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class DocFileTXTIntoDatabase {
  public static void main(String[] args) {
    Connection connection = null;
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=InsertFileTXTIntoDatabase;user=sa;password=55555");
      Statement st = connection.createStatement();

      FileInputStream fstream = new FileInputStream("./readFileTXTIntoDatabase.txt");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String strLine;
      ArrayList list = new ArrayList();
      while ((strLine = br.readLine()) != null) {
        list.add(strLine);
      }
      Iterator itr;
      for (itr = list.iterator(); itr.hasNext();) {
        String str = itr.next().toString();
        String[] splitSt = str.split(";");
        String maSinhVien = "", ten = "", soDienThoai = "", email = "", diem = "";
        for (int i = 0; i < splitSt.length; i++) {
          maSinhVien = splitSt[0];
          ten = splitSt[1];
          soDienThoai = splitSt[2];
          email = splitSt[3];
          diem = splitSt[4];
        }

        int k = st.executeUpdate(" INSERT dbo.SinhVien( MaSinhVien ,Ten ,SoDienThoai ,Email ,Diem)"
            + "VALUES  ( N' " + maSinhVien + " ' , N' " + ten + " ' , N' " + soDienThoai + " ' , N' "+ email +" ' ,  " + diem + " ) ");
      }
      System.out.println("Thêm dữ liệu từ file txt thành công");
    } catch (Exception e) {
    }
  }
}