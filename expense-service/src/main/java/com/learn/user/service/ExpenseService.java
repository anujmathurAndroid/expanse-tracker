package com.learn.user.service;

import com.learn.user.client.userClient;
import com.learn.user.dto.ExpenseDetail;
import com.learn.user.dto.User;
import com.learn.user.repository.ExpenseServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private userClient userClient;

    @Autowired
    private ExpenseServiceRepository serviceRepository;

    public ExpenseDetail getExpenseById(String expenseId){
        ExpenseDetail expenseDetail = serviceRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        return expenseDetail;
    }

    public List<ExpenseDetail> getExpensesByUserId(String userId) {
        return serviceRepository.findByUserId(userId);
    }

    public ExpenseDetail createExpense(ExpenseDetail expense) {
        return serviceRepository.save(expense);
    }
}
