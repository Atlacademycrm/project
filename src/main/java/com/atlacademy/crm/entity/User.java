package com.atlacademy.crm.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private char[] password;

    @OneToMany(mappedBy = "createdBy",cascade = CascadeType.REMOVE,orphanRemoval = true,fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Ticket> createdTickets=new ArrayList<>();
}
