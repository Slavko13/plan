package ru.dayPlanning.domain;


import javax.persistence.*;

@Entity
public class TimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fileName;

    public Clients getClientsTime() {
        return clientsTime;
    }

    public void setClientsTime(Clients clientsTime) {
        this.clientsTime = clientsTime;
    }

    @ManyToOne
    private Clients clientsTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
