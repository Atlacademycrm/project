package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.TicketCategory;
import com.atlacademy.crm.service.TicketCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class TicketCategoryController {

    private TicketCategoryService ticketCategoryService;

    public TicketCategoryController(TicketCategoryService ticketCategoryService) {
        this.ticketCategoryService = ticketCategoryService;
    }

    @GetMapping("/categories")
    List<TicketCategory> categories() {
        return ticketCategoryService.findAll();
    }
}
