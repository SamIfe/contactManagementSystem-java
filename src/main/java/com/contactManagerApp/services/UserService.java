package com.contactManagerApp.services;

import com.contactManagerApp.data.models.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);
    User updateLastLogin(String UserId);
    Optional<User> findByUsername(String userId);
}
