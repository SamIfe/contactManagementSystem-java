package com.contactManagerApplication.services;

import com.contactManagerApplication.data.models.User;
import com.contactManagerApplication.data.repositories.UserRepository;
import com.contactManagerApplication.exceptions.UserExceptions.UserNotFoundExecption;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

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
