package com.learn.user.controller;

import com.learn.user.dto.ExpenseDetail;
import com.learn.user.dto.User;
import com.learn.user.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDetail> getExpenseById(@PathVariable("id") String id) {
        ExpenseDetail expense = expenseService.getExpenseById(id);
        return ResponseEntity.ok(expense);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ExpenseDetail>> getExpenseByUserId(@PathVariable("userId") String userId) {
        List<ExpenseDetail> expenses = expenseService.getExpensesByUserId(userId);

        return ResponseEntity.ok(expenses);
    }

    @PostMapping("/createExpense")
    public ResponseEntity<ExpenseDetail> createExpense(@RequestBody ExpenseDetail expense){
        ExpenseDetail savedExpense = expenseService.createExpense(expense);

        return ResponseEntity.ok(savedExpense);
    }
}
