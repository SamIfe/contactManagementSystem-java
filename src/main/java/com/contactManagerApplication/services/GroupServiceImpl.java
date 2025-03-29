package com.contactManagerApplication.services;

import com.contactManagerApplication.data.models.Contact;
import com.contactManagerApplication.data.models.Group;
import com.contactManagerApplication.data.repositories.GroupRepository;
import com.contactManagerApplication.data.repositories.ContactRepository;

import com.contactManagerApplication.exceptions.groupExeceptions.GroupNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{
        @Autowired
        private final GroupRepository groupRepository;

        @Autowired
        private final ContactRepository contactRepository;

        public Group createGroup(Group group) {
            group.setCreatedAt(LocalDateTime.now());
            return groupRepository.save(group);
        }

        public Group updateGroup(String id, Group updatedGroup) {
            return groupRepository.findById(id)
                    .map(existingGroup -> {
                        existingGroup.setName(updatedGroup.getName());
                        existingGroup.setDescription(updatedGroup.getDescription());
                        return groupRepository.save(existingGroup);
                    })
                    .orElseThrow(() -> new GroupNotFoundException("Group not found"));
        }

        public void deleteGroup(String id) {
            Group group = groupRepository.findById(id)
                    .orElseThrow(() -> new GroupNotFoundException("Group not found"));

            for (Contact contact : group.getContacts()) {
                contact.getGroups().remove(group);
                contactRepository.save(contact);
            }

            groupRepository.delete(group);
        }

        public List<Group> getAllGroups() {
            return groupRepository.findAll();
        }

        public Optional<Group> getGroupById(String id) {
            return Optional.ofNullable(groupRepository.findById(id)
                    .orElseThrow(() -> new GroupNotFoundException("Target group not found")));
        }

//    @Override
//    public Optional<Group> addContactToGroup(String groupId, Contact contact) {
//        return Optional.empty();
//    }

//    @Override
//    public Optional<Group> removeContactFromGroup(String groupId, Contact contact) {
//        Optional<Group> groupContact = Optional.ofNullable(groupRepository.findById(groupId)
//                .orElseThrow(() -> new ContactNotFoundException("Contact not found")));
//        if(groupContact.isPresent()){
//            Group group = groupContact.get();
//            group.removeContact(contact);
//            return Optional.of(groupRepository.save(group));
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<Group> getGroupByName(String name) {
//        return Optional.empty();
//    }
}
