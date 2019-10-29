package ru.dayPlanning;

import ru.dayPlanning.domain.Home;
import ru.dayPlanning.ejb.HomeManagerBean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@SessionScoped
public class HomeBean implements Serializable {
    private String address;
    private Home home;
    private String login;


    @EJB
    HomeManagerBean homeManagerBean;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Home createHome(String login) {
        String temp;
        temp = getAddress();
        home = homeManagerBean.createHome(temp, login);
        return home;
    }

    public List<Home> getHomes() {
       return homeManagerBean.getUserHomes();
    }

}
