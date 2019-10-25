package ru.dayPlanning.domain;

import javax.persistence.*;
import java.util.List;


@Entity
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String address;

    @OneToMany(fetch =FetchType.EAGER, mappedBy = "home")
    private List<ClientsInHome> home_inHomeList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ClientsInHome> getUser_inHomeList() {
        return home_inHomeList;
    }

    public void setUser_inHomeList(List<ClientsInHome> user_inHomeList) {
        this.home_inHomeList = user_inHomeList;
    }
}
