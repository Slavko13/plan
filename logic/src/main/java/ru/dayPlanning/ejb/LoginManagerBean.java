package ru.dayPlanning.ejb;

import ru.dayPlanning.domain.Clients;
import ru.dayPlanning.domain.Home;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class LoginManagerBean {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("planManager");
    EntityManager entityManager = factory.createEntityManager();
    public boolean loginIn(String login, String password) {
        if (login == null  || password == null) {
            return false;
        }

        entityManager.getTransaction().begin();

        Clients client = entityManager.find(Clients.class, login);
        entityManager.getTransaction().commit();
        System.out.println("hui");
        String test = client.getLogin();
        if (client == null) {
            return false;
        }

        return client.getPassword().equals(password);
    }

}
