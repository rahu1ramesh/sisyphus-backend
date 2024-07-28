package com.einherjar.sisyphus.dao;

import com.einherjar.sisyphus.model.Habit;

import java.util.Optional;

public interface HabitRepository {
    Optional<Habit> findById(int habitId);

    void save(Habit habit);

    void delete(Habit habit);
}
