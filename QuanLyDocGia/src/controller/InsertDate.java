package controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class InsertDate {
    public static void main(String[] args) {
        Connection connection = null;
        try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyDocGia;user=sa;password=55555");
          Statement st = connection.createStatement();

          FileInputStream fstream = new FileInputStream("./input1.txt");
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
            String studentID = "", fullName = "", birthDay = "", sex = "", phone = "",email = "",startDateJoinedLE = "", endDateJoinedLE = "";
            for (int i = 0; i < splitSt.length; i++) {
                studentID = splitSt[0];
                fullName = splitSt[1];
                birthDay = splitSt[2];
                sex = splitSt[3];
                phone = splitSt[4];
                email = splitSt[5];
                startDateJoinedLE = splitSt[6];
                endDateJoinedLE = splitSt[7];
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMDD");
            Date dateBirth = null;
            Date dateStart = null;
            Date dateEnd = null;
            try {
                dateBirth = dateFormat.parse(birthDay);
                dateStart = dateFormat.parse(startDateJoinedLE);
                dateEnd = dateFormat.parse(endDateJoinedLE);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            int k = st.executeUpdate(" INSERT dbo.SinhVien( StudentID ,FullName ,BirthDay ,Sex ,Phone,Emai,StartDateJoinedLE, EndDateJoinedLE)"
                + "VALUES  ( N' " + studentID + " ' , N' " + fullName + " ' , " + new java.sql.Date(dateBirth.getTime()) + "  , N' "+ sex +" ' ,  N' " + phone + " ', N' " + email + " ', " + new java.sql.Date(dateStart.getTime()) + ", " + new java.sql.Date(dateEnd.getTime()) + " ) ");
          }
          System.out.println("Thêm dữ liệu từ file txt thành công");
        } catch (Exception e) {
        }
      }
}
