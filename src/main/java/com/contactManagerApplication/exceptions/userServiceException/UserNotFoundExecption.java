package com.contactManagerApplication.exceptions.userServiceException;

import com.contactManagerApplication.exceptions.contactServiceException.ContactNotFoundException;

public class UserNotFoundExecption extends ContactNotFoundException {
    public UserNotFoundExecption(String message) {
        super(message);
    }
}
