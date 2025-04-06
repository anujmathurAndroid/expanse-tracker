package com.learn.user.client;

import com.learn.user.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
@ComponentScan
public interface userClient {
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable("id")  String id);
}
