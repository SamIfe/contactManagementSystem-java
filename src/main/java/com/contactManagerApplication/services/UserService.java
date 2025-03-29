package com.contactManagerApplication.services;

import com.contactManagerApplication.data.models.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);
    User updateLastLogin(String UserId);
    Optional<User> findByUsername(String userId);
}
