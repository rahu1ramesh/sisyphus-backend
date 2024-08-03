package com.einherjar.sisyphus.dao;

import com.einherjar.sisyphus.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(int userId);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    void save(User user);

    void update(User user);

    void delete(User user);
}
