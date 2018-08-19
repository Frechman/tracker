package ru.gavrilov.tracker.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gavrilov.tracker.dao.UserRepository;
import ru.gavrilov.tracker.exceptions.ResourceNotFoundExceptions;
import ru.gavrilov.tracker.models.User;
import ru.gavrilov.tracker.services.UserRepositoryService;

import java.util.List;
import java.util.Optional;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService {

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        if (user != null) {
            userRepository.save(user);
        }
    }

    @Override
    public void update(Long id, User user) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("User", "id", id));

        foundUser.setFirstName(user.getFirstName());
        foundUser.setLastName(user.getLastName());
        foundUser.setAge(user.getAge());
        userRepository.save(foundUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
