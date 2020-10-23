package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.TicketCategory;
import com.atlacademy.crm.response.BaseResponse;
import com.atlacademy.crm.service.TicketCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/categories")
public class TicketCategoryController {

    private TicketCategoryService ticketCategoryService;

    public TicketCategoryController(TicketCategoryService ticketCategoryService) {
        this.ticketCategoryService = ticketCategoryService;
    }

    @GetMapping
    BaseResponse ticketCategories() {
        return new BaseResponse(ticketCategoryService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BaseResponse newTicketCategory(@RequestBody TicketCategory ticketCategory) {
        log.info(ticketCategory.toString());
        return new BaseResponse(ticketCategoryService.save(ticketCategory));
    }

    @GetMapping("/{id}")
    BaseResponse singleTicketCategory(@PathVariable Long id) {
        return new BaseResponse(ticketCategoryService.getById(id));
    }

    @PutMapping("/{id}")
    BaseResponse updateTicketCategory(@PathVariable Long id, @RequestBody TicketCategory ticketCategory) {
        return new BaseResponse(ticketCategoryService.updateById(id, ticketCategory));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTicketCategory(@PathVariable Long id) {
        ticketCategoryService.deleteById(id);
    }
}
