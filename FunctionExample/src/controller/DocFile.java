package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DocFile {
    public static void main(String[] args) {
        try {
            String input = "./readFile.txt";
            FileInputStream fis = new FileInputStream(new File(input));
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line != null && !line.isEmpty()) {
                    System.out.println(line);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}