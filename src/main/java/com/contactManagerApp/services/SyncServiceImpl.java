package com.contactManagerApp.services;


import com.contactManagerApp.exceptions.synchronizationExecptions.UnsupportedSyncingOperationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SyncServiceImpl implements SyncService {

    public void syncWithExternalProvider(String provider, String credentials) {
        // Future implementation for syncing contacts with external providers
        throw new UnsupportedSyncingOperationException("Synchronization not yet implemented");
    }
}
