package com.einherjar.sisyphus.dao.impl;

import com.einherjar.sisyphus.dao.HabitLogRepository;
import com.einherjar.sisyphus.model.HabitLog;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class HabitLogRepositoryImpl implements HabitLogRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<HabitLog> findById(Long logId) {
        return Optional.ofNullable(entityManager.find(HabitLog.class, logId));
    }

    @Override
    public List<HabitLog> findByUserId(Long userId) {
        return entityManager.createQuery("SELECT hl FROM HabitLog hl WHERE hl.user.userId = :userId", HabitLog.class).setParameter("userId", userId).getResultList();
    }

    @Override
    public List<HabitLog> findByHabitId(Long habitId) {
        return entityManager.createQuery("SELECT hl FROM HabitLog hl WHERE hl.habit.habitId = :habitId", HabitLog.class).setParameter("habitId", habitId).getResultList();
    }

    @Override
    public List<HabitLog> findByUserIdAndHabitId(Long userId, Long habitId) {
        return entityManager.createQuery("SELECT hl FROM HabitLog hl WHERE hl.user.userId = :userId AND hl.habit.habitId = :habitId", HabitLog.class).setParameter("userId", userId).setParameter("habitId", habitId).getResultList();
    }

    @Override
    public List<HabitLog> findByUserIdAndHabitIdAndLogDate(Long userId, Long habitId, LocalDate logDate) {
        return entityManager.createQuery("SELECT hl FROM HabitLog hl WHERE hl.user.userId = :userId AND hl.habit.habitId = :habitId AND hl.logDate = :logDate", HabitLog.class).setParameter("userId", userId).setParameter("habitId", habitId).setParameter("logDate", logDate).getResultList();
    }

    @Transactional
    @Override
    public void save(HabitLog habitLog) {
        entityManager.persist(habitLog);
    }

    @Transactional
    @Override
    public void delete(HabitLog habitLog) {
        if (entityManager.contains(habitLog)) {
            entityManager.remove(habitLog);
        } else {
            entityManager.remove(entityManager.merge(habitLog));
        }
    }
}