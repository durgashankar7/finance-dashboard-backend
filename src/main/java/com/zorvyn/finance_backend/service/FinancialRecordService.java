package com.zorvyn.finance_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zorvyn.finance_backend.dto.DashboardSummary;
import com.zorvyn.finance_backend.entity.FinancialRecord;
import com.zorvyn.finance_backend.repository.FinancialRecordRepository;

@Service
public class FinancialRecordService {

    @Autowired
    private FinancialRecordRepository recordRepository;

    // Naya income ya expense record add karne ke liye
    public FinancialRecord addRecord(FinancialRecord record) {
        return recordRepository.save(record);
    }

    // Saare records dekhne ke liye
    public List<FinancialRecord> getAllRecords() {
        return recordRepository.findAll();
    }
    
    // ID se record delete karne ke liye
    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
    // Import DTO at the top of the file: 
    public DashboardSummary getDashboardSummary() {
        Double totalIncome = recordRepository.getTotalIncome();
        Double totalExpense = recordRepository.getTotalExpense();
        Double netBalance = totalIncome - totalExpense;

        return new DashboardSummary(totalIncome, totalExpense, netBalance);
    }
}