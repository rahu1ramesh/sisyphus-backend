package com.einherjar.sisyphus.dao.impl;

import com.einherjar.sisyphus.dao.HabitRepository;
import com.einherjar.sisyphus.model.Habit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class HabitRepositoryImpl implements HabitRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Habit> findById(int habitId) {
        return Optional.ofNullable(entityManager.find(Habit.class, habitId));
    }

    @Transactional
    @Override
    public void save(Habit habit) {
        entityManager.persist(habit);
    }

    @Transactional
    @Override
    public void delete(Habit habit) {
        if (entityManager.contains(habit)) {
            entityManager.remove(habit);
        } else {
            entityManager.remove(entityManager.merge(habit));
        }
    }
}
