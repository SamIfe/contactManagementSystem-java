package com.contactManagerApp.services;

import com.contactManagerApp.data.models.User;
import com.contactManagerApp.data.repositories.UserRepository;
import com.contactManagerApp.exceptions.UserExceptions.UserNotFoundExecption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User updateLastLogin(String userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setLastLogin(LocalDateTime.now());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundExecption("User not found"));
    }
}
