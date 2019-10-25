package ru.dayPlanning.auth;

import ru.dayPlanning.ejb.LoginManagerBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    private String login;
    private String password;
    private boolean loggedIn;
    private String pageAfterLogin;

    @EJB
    LoginManagerBean loginManagerBean;

    public String getPageAfterLogin() {
        return pageAfterLogin;
    }

    public void setPageAfterLogin(String pageAfterLogin) {
        this.pageAfterLogin = pageAfterLogin;
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

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    private boolean checkFields() {
        return login == null || password == null;
    }
    public void loginIn() {
        if (checkFields()) {
            loggedIn = false;
            return;
        }
        loggedIn = loginManagerBean.loginIn(login, password);
        if (loggedIn) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(pageAfterLogin);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
