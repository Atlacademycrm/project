package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.Report;
import com.atlacademy.crm.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ReportController {
    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
    @GetMapping("/reports")
    List<Report> reports() {
        return reportService.findAll();
    }
    @PostMapping("/reports")
    Report newReport(@RequestBody Report report) {
        return reportService.save(report);
    }

    @GetMapping("/report/{id}")
    Report singleReport(@PathVariable Long id) {
        return reportService.getById(id);
    }

    @PutMapping("/report/{id}")
    Report updateReport(@PathVariable Long id) {
        Report report = reportService.getById(id);
        return reportService.save(report);
    }

    @DeleteMapping("/report/{id}")
    void deleteReport(@PathVariable Long id) {
        reportService.deleteById(id);
    }
}
