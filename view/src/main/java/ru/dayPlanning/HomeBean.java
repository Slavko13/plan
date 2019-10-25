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


    @EJB
    HomeManagerBean homeManagerBean;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void createHome() {
        String temp;
        temp = getAddress();
        home = homeManagerBean.createHome(temp);

    }

    public List<Home> getHomes() {
       return homeManagerBean.getHomes();
    }
}
