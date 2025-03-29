package com.contactManagerApplication.exceptions.contactExceptions;

import com.contactManagerApplication.exceptions.baseExceptions.ContactManagerException;

public class ContactNotFoundException extends ContactManagerException {
    public ContactNotFoundException(String contactNotFound) {
    }
}
