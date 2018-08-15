package ru.gavrilov.tracker.services;

import ru.gavrilov.tracker.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryService {

    void create(User user);

    void update(Long id, User user);

    void delete(Long id);

    Optional<User> findById(Long id);

    List<User> findAll();

    Optional<User> findByEmail(String email);
}
