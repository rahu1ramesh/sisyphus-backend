package com.einherjar.sisyphus.dao;

import com.einherjar.sisyphus.model.HabitLog;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HabitLogRepository {
    Optional<HabitLog> findById(int logId);

    List<HabitLog> findByUserId(int userId);

    List<HabitLog> findByHabitId(int habitId);

    List<HabitLog> findByUserIdAndHabitId(int userId, int habitId);

    List<HabitLog> findByUserIdAndHabitIdAndLogDate(int userId, int habitId, LocalDate logDate);

    void save(HabitLog habitLog);

    void update(HabitLog habitLog);

    void delete(HabitLog habitLog);
}
