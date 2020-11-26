package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.Report;
import com.atlacademy.crm.response.BaseResponse;
import com.atlacademy.crm.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    BaseResponse reports() {
        return new BaseResponse(reportService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BaseResponse newReport(@RequestBody Report report) {
        log.info(report.toString());
        return new BaseResponse(reportService.save(report));
    }

    @GetMapping("/{id}")
    BaseResponse singleReport(@PathVariable Long id) {
        return new BaseResponse(reportService.getById(id));
    }

    @PutMapping("/{id}")
    BaseResponse updateReport(@PathVariable Long id, @RequestBody Report report) {
        return new BaseResponse(reportService.updateById(id, report));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteReport(@PathVariable Long id) {
        reportService.deleteById(id);
    }
}
