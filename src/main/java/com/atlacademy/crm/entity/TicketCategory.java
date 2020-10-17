package com.atlacademy.crm.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ticket_categories")
@Data
public class TicketCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List <Ticket> tickets = new ArrayList<>();


}
