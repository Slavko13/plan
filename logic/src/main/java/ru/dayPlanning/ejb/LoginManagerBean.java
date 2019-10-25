package ru.dayPlanning.ejb;

import ru.dayPlanning.domain.Clients;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class LoginManagerBean {

    @PersistenceContext(unitName = "planManager")
    private EntityManager entityManager;

    public boolean loginIn(String login, String password) {
        if (login == null  || password == null) {
            return false;
        }
        Clients client = entityManager.find(Clients.class, login);
        String test = client.getLogin();
        if (client == null) {
            return false;
        }

        if (!client.getPassword().equals(password)) {
            return false;
        }

        return true;
    }

}
