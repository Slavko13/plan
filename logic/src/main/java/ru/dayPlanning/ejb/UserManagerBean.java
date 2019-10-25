package ru.dayPlanning.ejb;

import ru.dayPlanning.domain.Clients;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class UserManagerBean {

    @PersistenceContext(unitName = "planManager")
    private EntityManager entityManager;

    public Clients createUser(String first_name, String second_name, String password, String login, String email) {
        Clients clients = new Clients();
        clients.setFirst_name(first_name);
        clients.setLogin(login);
        clients.setPassword(password);
        clients.setSecond_name(second_name);
        clients.setEmail(email);
        entityManager.persist(clients);
        return clients;
    }
}
