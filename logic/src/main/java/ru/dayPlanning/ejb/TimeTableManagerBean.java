package ru.dayPlanning.ejb;


import ru.dayPlanning.domain.*;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless
public class TimeTableManagerBean {

    @PersistenceContext(unitName = "planManager")
    private EntityManager entityManager;


    public boolean addFile(String fileName, String login) {
        Clients client = entityManager.find(Clients.class, login);
        if (client == null) {
            return false;
        }
        TimeTable timeTable = new TimeTable();
        timeTable.setFileName(fileName);
        timeTable.setClientsTime(client);
        entityManager.persist(timeTable);
        return  true;
    }


}
