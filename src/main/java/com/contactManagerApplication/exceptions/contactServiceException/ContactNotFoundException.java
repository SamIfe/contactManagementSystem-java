package com.contactManagerApplication.exceptions.contactServiceException;

import com.contactManagerApplication.exceptions.rootException.ContactManagerException;

public class ContactNotFoundException extends ContactManagerException {
    public ContactNotFoundException(String contactNotFound) {
    }
}