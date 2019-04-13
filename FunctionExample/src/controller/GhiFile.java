package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author nguye
 *
 */
public class GhiFile {
    
 private static final String FILENAME = "./writeFile.txt";
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            String content = "Nội dung mình muốn viết vào file\n";
 
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            bw.write(content);
 
            System.out.println("Đã ghi vào file");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}