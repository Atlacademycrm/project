package com.atlacademy.crm.entity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="birthdate")
    private Date birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "preferred_communication")
    private CommunicationType preferredCommunication;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE,orphanRemoval = true,fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Ticket> tickets=new ArrayList<>();
}
