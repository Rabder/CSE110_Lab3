package edu.ucsd.spendingtracker.model;

import java.util.List;
import edu.ucsd.spendingtracker.repository.ExpenseRepository;

public class Model {
    private final ExpenseRepository repository;
    
    public Model(ExpenseRepository repository) {
        this.repository = repository;
    }

    // expose add Expense 
    public void addExpense(Expense e) {
        repository.addExpense(e);
    }

    public double getTotalSpending() {
        return repository.getTotal();
    }

    // expose get Expenses
    public List<Expense> getExpenses() {
        return repository.getExpenses();
    }
}
