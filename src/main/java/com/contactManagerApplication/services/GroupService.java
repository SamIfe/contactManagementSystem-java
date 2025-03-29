package com.contactManagerApplication.services;

import com.contactManagerApplication.data.models.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    Group createGroup(Group group);
    Group updateGroup(String id, Group updateGroup);
    void deleteGroup(String id);
    List<Group> getAllGroups();
    Optional<Group> getGroupById(String id);
//    Optional<Group> addContactToGroup(String groupId, Contact contact);
//    Optional<Group> removeContactFromGroup(String groupId, Contact contact);
//    Optional<Group> getGroupByName(String name);



}
