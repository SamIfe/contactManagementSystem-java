package com.contactManagerApp.services;

public interface SyncService {
    void syncWithExternalProvider(String provider, String credentials);
}
