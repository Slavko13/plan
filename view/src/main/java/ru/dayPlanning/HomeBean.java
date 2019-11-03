package ru.dayPlanning;

import ru.dayPlanning.domain.Home;
import ru.dayPlanning.ejb.HomeManagerBean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Named
@SessionScoped
public class HomeBean implements Serializable {
    private String address;
    private Home home;
    private String homeName;



    @EJB
    HomeManagerBean homeManagerBean;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public Home createHome(String login) {
        String temp;
        temp = getAddress();
        home = homeManagerBean.createHome(temp, login, homeName);
        return home;
    }

    public List<Home> getHomes(String login) {
       return homeManagerBean.getUserHomes(login);
    }

}
