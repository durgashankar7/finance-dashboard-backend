package com.zorvyn.finance_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zorvyn.finance_backend.entity.FinancialRecord;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {
    
    // Total Income nikalne ki query
    @Query("SELECT COALESCE(SUM(f.amount), 0.0) FROM FinancialRecord f WHERE f.recordType = 'INCOME'")
    Double getTotalIncome();

    // Total Expense nikalne ki query
    @Query("SELECT COALESCE(SUM(f.amount), 0.0) FROM FinancialRecord f WHERE f.recordType = 'EXPENSE'")
    Double getTotalExpense();
}