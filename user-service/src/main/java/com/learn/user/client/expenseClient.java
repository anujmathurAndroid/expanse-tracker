package com.learn.user.client;

import com.learn.user.dto.ExpenseDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "expense-service")
@ComponentScan
public interface expenseClient {

    @GetMapping("/expenses/user/{userId}")
    List<ExpenseDetail> getExpenseByUserId(@PathVariable("userId") String userId);
}
