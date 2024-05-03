package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface ExpenseRepository extends MongoRepository<Expense, String> {

    Optional<Expense> findByExpenseName(String name);

}
