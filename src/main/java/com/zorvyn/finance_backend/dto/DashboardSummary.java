package com.zorvyn.finance_backend.dto;

public class DashboardSummary {
    private Double totalIncome;
    private Double totalExpense;
    private Double netBalance;

    public DashboardSummary(Double totalIncome, Double totalExpense, Double netBalance) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.netBalance = netBalance;
    }

    // Getters and Setters
    public Double getTotalIncome() { return totalIncome; }
    public void setTotalIncome(Double totalIncome) { this.totalIncome = totalIncome; }

    public Double getTotalExpense() { return totalExpense; }
    public void setTotalExpense(Double totalExpense) { this.totalExpense = totalExpense; }

    public Double getNetBalance() { return netBalance; }
    public void setNetBalance(Double netBalance) { this.netBalance = netBalance; }
}