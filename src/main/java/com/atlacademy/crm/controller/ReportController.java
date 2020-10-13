package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.Report;
import com.atlacademy.crm.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ReportController {
    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
    @GetMapping("/api/reports")
    List<Report> reports() {
        return reportService.findAll();
    }
    @PostMapping("/api/reports")
    Report newReport(@RequestBody Report report) {
        return reportService.saveReport(report);
    }

    @GetMapping("/api/report/{id}")
    Report singleReport(@PathVariable Long id) {
        return reportService.getById(id);
    }

    @PutMapping("/api/report/{id}")
    Report updateReport(@PathVariable Long id) {
        Report report = reportService.getById(id);
        return reportService.saveReport(report);
    }

    @DeleteMapping("/api/report/{id}")
    void deleteReport(@PathVariable Long id) {
        reportService.deleteReportById(id);
    }
}
