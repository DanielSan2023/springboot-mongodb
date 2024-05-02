package com.example.springbootmongodb.service;

import com.example.springbootmongodb.model.Expense;
import com.example.springbootmongodb.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense) {
        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense) {
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Expense by Id %s", expense.getId())));

        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(savedExpense);
    }

    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name) {
        return expenseRepository.findByExpenseName(name)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find by name %s", name)));
    }

    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }
}
