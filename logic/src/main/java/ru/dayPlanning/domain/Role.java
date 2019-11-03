package ru.dayPlanning.domain;


import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String roleType;

    @OneToOne(mappedBy = "role")
    private Clients client;
}
