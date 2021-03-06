package com.atlacademy.crm.service;

import com.atlacademy.crm.entity.Report;
import com.atlacademy.crm.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    public Report getById(Long id) {
        return reportRepository.getOne(id);
    }

    public Report save(Report report) {
        return reportRepository.save(report);
    }

    public void deleteById(Long id) {
        reportRepository.delete(getById(id));
    }

    public Report updateById(Long id, Report report) {
        reportRepository.getOne(id);
        report.setId(id);
        return reportRepository.save(report);
    }
}
