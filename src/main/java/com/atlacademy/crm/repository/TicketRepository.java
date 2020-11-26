package com.atlacademy.crm.repository;

import com.atlacademy.crm.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository <Ticket,Long> {

    List<Ticket> getByCustomerId(long customerId);
}
