package ru.dayPlanning.ejb;

import ru.dayPlanning.domain.Clients;
import ru.dayPlanning.domain.ClientsInHome;
import ru.dayPlanning.domain.Home;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
@LocalBean
public class HomeManagerBean {

    @PersistenceContext(unitName = "planManager")
    private EntityManager entityManager;


    private boolean addToUser (String login, long homeId) {
        Clients client = entityManager.find(Clients.class, login);
        if (client == null) {
            return false;
        }

        Home home = entityManager.find(Home.class ,homeId);
        if (home == null ) {
            return false;
        }

        ClientsInHome clientsInHome = new ClientsInHome();
        clientsInHome.setClients(client);
        clientsInHome.setHome(home);
        entityManager.persist(clientsInHome);

        return true;
    }

    public Home createHome(String address, String login) {
        Home home = new Home();
        home.setAddress(address);
        entityManager.persist(home);
        addToUser(login, home.getId());
        return home;
    }


    public List<Home> getHomes() {
        TypedQuery<Home> query = entityManager.createQuery("select c from Home c", Home.class);
        return query.getResultList();
    }

    public List<Home> getUserHomes(String login) {
        Clients client = entityManager.find(Clients.class, login);
        if (client == null) {
            return Collections.emptyList();
        }

        List<ClientsInHome>  clients_inHomeList =  client.getClients_InHomeList();
        List<Home> homes = new ArrayList<>();
        for (ClientsInHome clientsInHome : clients_inHomeList ) {
            homes.add(clientsInHome.getHome());
        }
        return homes;
    }

}
