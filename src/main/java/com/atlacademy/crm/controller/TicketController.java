package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.Ticket;
import com.atlacademy.crm.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping("/api/tickets")
    List<Ticket> tickets() {
        return ticketService.findAll();
    }
    @PostMapping("/api/tickets")
    Ticket newTicket(@RequestBody Ticket Ticket) {
        return ticketService.save(Ticket);
    }

    @GetMapping("/api/ticket/{id}")
    Ticket singleTicket(@PathVariable Long id) {
        return ticketService.getById(id);
    }

    @PutMapping("/api/ticket/{id}")
    Ticket updateTicket(@PathVariable Long id) {
        Ticket ticket = ticketService.getById(id);
        return ticketService.save(ticket);
    }

    @DeleteMapping("/api/ticket/{id}")
    void deleteTicket(@PathVariable Long id) {
        ticketService.deleteById(id);
    }
}
