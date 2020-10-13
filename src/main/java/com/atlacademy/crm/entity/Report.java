package com.atlacademy.crm.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "reports")
@Data
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "based_on")
    private String basedOn;
}
