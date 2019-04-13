package Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
 
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "image/image_sach";
    private static final String UPLOAD_DIRECTORY2 = "SellingBooks/WebContent/image/image_sach";
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
 
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk 
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
 
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
 
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
 
        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("") // fix lại đường dẫn
                + File.separator + UPLOAD_DIRECTORY;
        
      String t = getServletContext().getRealPath(""); // fix lại đường dẫn

        String uploadPath2 = t.substring(0, 32) + File.separator + UPLOAD_DIRECTORY2;
        request.setAttribute("link", uploadPath2);
        
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        File uploadDir2 = new File(uploadPath2);
        if (!uploadDir2.exists()) {
            uploadDir2.mkdir();
        }
 
        try {
            java.util.List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        String filePath2 = uploadPath2 + File.separator + fileName;
                        File storeFile = new File(filePath);
                        File storeFile2 = new File(filePath2);
                        
                        // saves the file on disk
                        item.write(storeFile);
                        item.write(storeFile2);
                        request.setAttribute("msg", UPLOAD_DIRECTORY + "/" + fileName);
                        request.setAttribute("message",
                                "Upload has been done successfully >>" + UPLOAD_DIRECTORY + "/" + fileName);
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }
        // redirects client to message page
        getServletContext().getRequestDispatcher("/admin/message.jsp").forward(
                request, response);
    }
}
