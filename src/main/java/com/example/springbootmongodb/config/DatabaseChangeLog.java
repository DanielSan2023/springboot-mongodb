package com.example.springbootmongodb.config;

import com.example.springbootmongodb.model.Expense;
import com.example.springbootmongodb.model.ExpenseCategory;
import com.example.springbootmongodb.repository.ExpenseRepository;
import io.changock.migration.api.annotations.ChangeLog;
import io.changock.migration.api.annotations.ChangeSet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.example.springbootmongodb.model.ExpenseCategory.*;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "seedDatabase", author = "Sai")
    public void seedDatabase(ExpenseRepository expenseRepository) {
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(createNewExpense("Movie Tickets", ENTERTAINMENT, BigDecimal.valueOf(40)));
        expenseList.add(createNewExpense("Dinner", RESTAURANT, BigDecimal.valueOf(60)));
        expenseList.add(createNewExpense("Netflix", ENTERTAINMENT, BigDecimal.valueOf(10)));
        expenseList.add(createNewExpense("Gym", MISC, BigDecimal.valueOf(20)));
        expenseList.add(createNewExpense("Internet", UTILITIES, BigDecimal.valueOf(30)));

        expenseRepository.insert(expenseList);
    }

    private Expense createNewExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal amount) {
        Expense expense = new Expense();
        expense.setExpenseName(expenseName);
        expense.setExpenseAmount(amount);
        expense.setExpenseCategory(expenseCategory);
        return expense;
    }

}
