package ru.dayPlanning.auth;

import ru.dayPlanning.domain.Clients;
import ru.dayPlanning.ejb.UserManagerBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class RegistrationBean implements Serializable {
    private String first_name;
    private String second_name;
    private String login;
    private String password;
    private Clients clients;
    private String email;


    @EJB
    UserManagerBean userManagerBean;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void createUser() {
        if (userManagerBean.existedUser(login) == null) {
            clients = userManagerBean.createUser(first_name, second_name, password, login, email);
        }
        if (clients != null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/view/auth/login.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
