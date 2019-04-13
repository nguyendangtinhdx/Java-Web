package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import au.com.bytecode.opencsv.CSVReader;

public class DocFileCSVIntoDatabase {
  public static void main(String[] args)

  {

    readCsv();

    readCsvUsingLoad();

  }

  private static void readCsv()

  {

    try (CSVReader reader = new CSVReader(new FileReader("./STD.csv"), ';');

        Connection connection = DBConnection.getConnection();)

    {

      String insertQuery = "Insert into SinhVien (MaSinhVien,Ten, SoDienThoai, Email,Diem) values (?,?,?,?,?)";

      PreparedStatement pstmt = connection.prepareStatement(insertQuery);

      String[] rowData = null;

      int i = 0;

      while ((rowData = reader.readNext()) != null)

      {

        for (String data : rowData)

        {

          pstmt.setString((i % 3) + 1, data);
          if (++i % 3 == 0)
            pstmt.addBatch();// add batch

          if (i % 30 == 0)// insert when the batch size is 10
            pstmt.executeBatch();
        }
      }
      System.out.println("Data Successfully Uploaded");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void readCsvUsingLoad() {
    try (Connection connection = DBConnection.getConnection()) {

      String loadQuery = "LOAD DATA LOCAL INFILE '" + "C://Users/nguye/eclipse-workspace/FunctionExample/src/controller/STD.csv" + "' INTO TABLE SinhVien FIELDS TERMINATED BY ','" + " LINES TERMINATED BY '\n' (MaSinhVien, Ten, SoDienThoai, Email, Diem) ";
      System.out.println(loadQuery);
      Statement stmt = connection.createStatement();
      stmt.execute(loadQuery);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
