package com.atlacademy.crm.service;

import com.atlacademy.crm.entity.TicketCategory;
import com.atlacademy.crm.repository.TicketCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketCategoryService {
    TicketCategoryRepository ticketCategoryRepository;

    public TicketCategoryService(TicketCategoryRepository ticketRepository) {
        this.ticketCategoryRepository = ticketRepository;
    }

    public List<TicketCategory> findAll() {
        return ticketCategoryRepository.findAll();
    }

    public TicketCategory getById(Long id) {
        return ticketCategoryRepository.getOne(id);
    }

    public TicketCategory save(TicketCategory category) {
        return ticketCategoryRepository.save(category);
    }

    public void deleteById(Long id) {
        ticketCategoryRepository.delete(getById(id));
    }

    public TicketCategory updateById(Long id, TicketCategory ticketCategory) {
        ticketCategoryRepository.getOne(id);
        ticketCategory.setId(id);
        return ticketCategoryRepository.save(ticketCategory);
    }
}
