package com.atlacademy.crm.repository;

import com.atlacademy.crm.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository <Ticket,Long> {

}
