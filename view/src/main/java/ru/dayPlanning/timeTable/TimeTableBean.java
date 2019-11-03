package ru.dayPlanning.timeTable;


import ru.dayPlanning.ejb.TimeTableManagerBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

@Named
@SessionScoped
public class TimeTableBean implements Serializable {
    private Part file1;
    private static final String SAVE_DIR = "D:\\myProjects\\sources\\plan\\view\\src\\main\\webapp\\uploads\\" ;

    @EJB
    TimeTableManagerBean timeTableManagerBean;


    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public boolean upload(String login) throws IOException {
        String fileName = getFilename(login);
        file1.write(SAVE_DIR + fileName);
        timeTableManagerBean.addFile(fileName, login);
        return true;
    }


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
}
