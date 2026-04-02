package com.zorvyn.finance_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zorvyn.finance_backend.dto.DashboardSummary;
import com.zorvyn.finance_backend.entity.FinancialRecord;
import com.zorvyn.finance_backend.service.FinancialRecordService;

@RestController
@RequestMapping("/api/records")
public class FinancialRecordController {

    @Autowired
    private FinancialRecordService recordService;

    // Naya record add karne ka endpoint (POST request)
    @PostMapping
    public ResponseEntity<FinancialRecord> addRecord(@RequestBody FinancialRecord record) {
        FinancialRecord savedRecord = recordService.addRecord(record);
        return ResponseEntity.ok(savedRecord);
    }

    // Saare records nikalne ka endpoint (GET request)
    @GetMapping
    public ResponseEntity<List<FinancialRecord>> getAllRecords() {
        return ResponseEntity.ok(recordService.getAllRecords());
    }

    // Record delete karne ka endpoint (DELETE request)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
        return ResponseEntity.ok("Record deleted successfully!");
    }
    // Import DTO at the top of the file: 
    // import com.zorvyn.finance_backend.dto.DashboardSummary;

    // Dashboard summary ka endpoint (GET /api/records/dashboard/summary)
    @GetMapping("/dashboard/summary")
    public ResponseEntity<DashboardSummary> getDashboardSummary() {
        return ResponseEntity.ok(recordService.getDashboardSummary());
    }
}