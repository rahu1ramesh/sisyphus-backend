package com.einherjar.sisyphus.model;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "habit_log")
public class HabitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_habit_id", referencedColumnName = "id")
    private UserHabit userHabit;

    @Column(name = "log_date", nullable = false)
    private LocalDateTime logDate;

    @Column(name = "completed", nullable = false)
    private Boolean completed;

    @Column(name = "comments")
    private String comments;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public HabitLog() {
    }

    public HabitLog(UserHabit userHabit, LocalDateTime logDate, Boolean completed, String comments) {
        this.userHabit = userHabit;
        this.logDate = logDate;
        this.completed = completed;
        this.comments = comments;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserHabit getUserHabit() {
        return userHabit;
    }

    public void setUserHabit(UserHabit userHabit) {
        this.userHabit = userHabit;
    }

    public LocalDateTime getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDateTime logDate) {
        this.logDate = logDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("userHabit", userHabit)
                .append("logDate", logDate)
                .append("completed", completed)
                .append("comments", comments)
                .append("createdAt", createdAt)
                .toString();
    }
}
