package com.einherjar.sisyphus.dao;

import com.einherjar.sisyphus.model.HabitLog;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HabitLogRepository {
    Optional<HabitLog> findById(Long logId);

    List<HabitLog> findByUserId(Long userId);

    List<HabitLog> findByHabitId(Long habitId);

    List<HabitLog> findByUserIdAndHabitId(Long userId, Long habitId);

    List<HabitLog> findByUserIdAndHabitIdAndLogDate(Long userId, Long habitId, LocalDate logDate);

    void save(HabitLog habitLog);

    void delete(HabitLog habitLog);
}
