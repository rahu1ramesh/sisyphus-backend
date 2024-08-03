package com.einherjar.sisyphus.dao.impl;

import com.einherjar.sisyphus.dao.UserHabitRepository;
import com.einherjar.sisyphus.model.UserHabit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserHabitRepositoryImpl implements UserHabitRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<UserHabit> findById(int userHabitId) {
        return Optional.ofNullable(entityManager.find(UserHabit.class, userHabitId));
    }

    @Override
    public List<UserHabit> findByUserId(int userId) {
        return entityManager.createQuery("SELECT uh FROM UserHabit uh WHERE uh.user.userId = :userId", UserHabit.class).setParameter("userId", userId).getResultList();
    }

    @Override
    public List<UserHabit> findByHabitId(int habitId) {
        return entityManager.createQuery("SELECT uh FROM UserHabit uh WHERE uh.habit.habitId = :habitId", UserHabit.class).setParameter("habitId", habitId).getResultList();
    }

    @Override
    public Optional<UserHabit> findByUserIdAndHabitId(int userId, int habitId) {
        return entityManager.createQuery("SELECT uh FROM UserHabit uh WHERE uh.user.userId = :userId AND uh.habit.habitId = :habitId", UserHabit.class).setParameter("userId", userId).setParameter("habitId", habitId).getResultList().stream().findFirst();
    }

    @Transactional
    @Override
    public void save(UserHabit userHabit) {
        entityManager.persist(userHabit);
    }

    @Transactional
    @Override
    public void update(UserHabit userHabit) {
        entityManager.merge(userHabit);
    }

    @Transactional
    @Override
    public void delete(UserHabit userHabit) {
        if (entityManager.contains(userHabit)) {
            entityManager.remove(userHabit);
        } else {
            entityManager.remove(entityManager.merge(userHabit));
        }
    }
}
