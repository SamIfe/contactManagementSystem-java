package com.contactManagerApp.exceptions.UserExceptions;

import com.contactManagerApp.exceptions.contactExceptions.ContactNotFoundException;

public class UserNotFoundExecption extends ContactNotFoundException {
    public UserNotFoundExecption(String message) {
        super(message);
    }
}
