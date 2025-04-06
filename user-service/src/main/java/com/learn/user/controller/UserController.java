package com.learn.user.controller;

import com.learn.user.dto.ExpenseDetail;
import com.learn.user.dto.User;
import com.learn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
    User user = userService.getUserById(id);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/expenses/{id}")
    public ResponseEntity<List<ExpenseDetail>> getUserWithExpenses(@PathVariable("id") String id) {
        List<ExpenseDetail> expenses = userService.getUserWithExpenses(id);
        return ResponseEntity.ok(expenses);
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

}
