package ru.dayPlanning.timeTable;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Date;

@WebServlet("/main/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)   // 50MB
public class UploadServlet extends HttpServlet {
    private static final String SAVE_DIR = "D:\\myProjects\\sources\\plan\\view\\src\\main\\webapp\\uploads\\" ;

    private String getFilename(String login) {
        Integer temp;
        String fileName;
        Date date = new Date();
        Long millis = date.getTime();
        fileName = millis.toString();
        temp = login.hashCode();
        fileName = fileName + temp.toString() + ".jpg";
        return fileName;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Part part : req.getParts()) {
            String fileName = getFilename("Slava");
            part.write(SAVE_DIR + fileName);
        }
        req.setAttribute("message", "Upload has been done successfully!");
        getServletContext().getRequestDispatcher("/main/TimeTable.xhtml").forward(
                req, resp);
    }
    }

