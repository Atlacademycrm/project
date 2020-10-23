package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.Ticket;
import com.atlacademy.crm.response.BaseResponse;
import com.atlacademy.crm.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    BaseResponse tickets() {
        return new BaseResponse(ticketService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BaseResponse newTicket(@RequestBody Ticket ticket) {
        log.info(ticket.toString());
        return new BaseResponse(ticketService.save(ticket));
    }

    @GetMapping("/{id}")
    BaseResponse singleTicket(@PathVariable Long id) {
        return new BaseResponse(ticketService.getById(id));
    }

    @PutMapping("/{id}")
    BaseResponse updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        return new BaseResponse(ticketService.updateById(id, ticket));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTicket(@PathVariable Long id) {
        ticketService.deleteById(id);
    }
}
