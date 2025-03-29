package com.contactManagerApplication.services;

public interface SyncService {
    void syncWithExternalProvider(String provider, String credentials);
}
