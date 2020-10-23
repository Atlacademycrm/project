package com.atlacademy.crm.entity;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Ticket implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "header")
    private String header;

    @Column(name = "priority_degree")
    @Enumerated(EnumType.STRING)
    private PriorityDegree priorityDegree;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private TicketCategory category;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private User createdBy;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Customer customer;
}
