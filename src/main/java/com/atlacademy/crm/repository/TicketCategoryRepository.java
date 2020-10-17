package com.atlacademy.crm.repository;

import com.atlacademy.crm.entity.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long> {
}
