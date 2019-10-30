package ru.dayPlanning.domain;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "clients")
public class Clients {

    @Id
    private String login;
    private String first_name;
    private String second_name;
    private String password;
    private String email;
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @OneToMany(fetch =FetchType.EAGER, mappedBy = "clients")
    private List<ClientsInHome> clients_InHomeList;


    @OneToOne
    private Role role;


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public List<ClientsInHome> getClients_InHomeList() {
        return clients_InHomeList;
    }

    public void setClients_InHomeList(List<ClientsInHome> clients_InHomeList) {
        this.clients_InHomeList = clients_InHomeList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
