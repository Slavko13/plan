package ru.dayPlanning.ejb;

import ru.dayPlanning.domain.Home;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class HomeManagerBean {

    @PersistenceContext(unitName = "planManager")
    private EntityManager entityManager;

    public Home createHome(String address) {
        Home home = new Home();
        home.setAddress(address);

        entityManager.persist(home);
        return home;
    }

    public List<Home> getHomes() {
        TypedQuery<Home> query = entityManager.createQuery("select c from Home c", Home.class);
        return query.getResultList();
    }
}
