package com.learn.user.service;

import com.learn.user.client.expenseClient;
import com.learn.user.dto.ExpenseDetail;
import com.learn.user.dto.User;
import com.learn.user.repository.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private expenseClient expenseClient;

    @Autowired
    private UserServiceRepository userRepository;

    public List<ExpenseDetail> getUserWithExpenses(String userId){
        List<ExpenseDetail> expenses = expenseClient.getExpenseByUserId(userId);
        return expenses;
    }

    public User getUserById(String userId){
        User userDto = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return userDto;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
}
