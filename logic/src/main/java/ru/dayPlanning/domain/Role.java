package ru.dayPlanning.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Role {
    @Id
    private long id;
    private String roleType;

    @OneToOne(mappedBy = "role")
    private Clients client;
}
