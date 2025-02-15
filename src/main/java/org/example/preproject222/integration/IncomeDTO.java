package org.example.preproject222.integration;

public class IncomeDTO {
    private Long id;
    private int income;

    public IncomeDTO(Long id, int income) {
        this.id = id;
        this.income = income;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
