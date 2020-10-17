package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.Ticket;
import com.atlacademy.crm.entity.TicketCategory;
import com.atlacademy.crm.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping("/tickets")
    List<Ticket> tickets() {
        return ticketService.findAll();
    }
    @PostMapping("/tickets")
    Ticket newTicket(@RequestBody Ticket Ticket) {
        return ticketService.save(Ticket);
    }

    @GetMapping("/ticket/{id}")
    Ticket singleTicket(@PathVariable Long id) {
        return ticketService.getById(id);
    }

    @PutMapping("/ticket/{id}")
    Ticket updateTicket(@PathVariable Long id) {
        Ticket ticket = ticketService.getById(id);
        return ticketService.save(ticket);
    }

    @DeleteMapping("/ticket/{id}")
    void deleteTicket(@PathVariable Long id) {
        ticketService.deleteById(id);
    }
}
