package com.atlacademy.crm.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "header")
    private String header;

    @Column(name = "priority_degree")
    private PriorityDegree priorityDegree;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @ToString.Exclude
    private TicketCategory category;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @ToString.Exclude
    private User createdBy;

    @ManyToOne
    @ToString.Exclude
    private Customer customer;
}
