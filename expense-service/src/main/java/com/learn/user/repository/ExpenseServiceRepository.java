package com.learn.user.repository;

import com.learn.user.dto.ExpenseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseServiceRepository extends JpaRepository<ExpenseDetail, String> {
    List<ExpenseDetail> findByUserId(String userId);
}
