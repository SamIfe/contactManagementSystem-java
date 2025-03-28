package com.contactManagerApp.exceptions.contactExceptions;

import com.contactManagerApp.exceptions.baseExceptions.ContactManagerException;

public class ContactNotFoundException extends ContactManagerException {
    public ContactNotFoundException(String contactNotFound) {
    }
}
