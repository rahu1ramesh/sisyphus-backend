package com.einherjar.sisyphus.dao;

import com.einherjar.sisyphus.model.UserHabit;

import java.util.List;
import java.util.Optional;

public interface UserHabitRepository {
    Optional<UserHabit> findById(int userHabitId);

    List<UserHabit> findByUserId(int userId);

    List<UserHabit> findByHabitId(int habitId);

    Optional<UserHabit> findByUserIdAndHabitId(int userId, int habitId);

    void save(UserHabit userHabit);

    void update(UserHabit userHabit);

    void delete(UserHabit userHabit);
}