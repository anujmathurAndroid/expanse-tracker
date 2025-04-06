package com.learn.user.dto;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class ExpenseDetail {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    private BigDecimal amount;
    private String category;
    private LocalDate date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public ExpenseDetail() {
    }

    public ExpenseDetail(BigDecimal amount, String category, LocalDate date, String description, User user) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
        this.user = user;
    }

    public ExpenseDetail(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = this.id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
