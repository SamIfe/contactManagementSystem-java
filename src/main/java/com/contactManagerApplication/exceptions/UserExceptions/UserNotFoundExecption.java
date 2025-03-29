package com.contactManagerApplication.exceptions.UserExceptions;

import com.contactManagerApplication.exceptions.contactExceptions.ContactNotFoundException;

public class UserNotFoundExecption extends ContactNotFoundException {
    public UserNotFoundExecption(String message) {
        super(message);
    }
}
