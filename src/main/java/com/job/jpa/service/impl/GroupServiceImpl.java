package com.job.jpa.service.impl;

import com.job.jpa.model.group.Group;
import com.job.jpa.model.group.Visibility;
import com.job.jpa.model.user.User;
import com.job.jpa.repo.GroupRepository;
import com.job.jpa.repo.UserRepository;
import com.job.jpa.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {
    private GroupRepository groupRepository;
    private UserRepository userRepository;

    @Override
    public Group findOne(String groupId) {
       return groupRepository.findByGroupId(groupId);
    }

    @Override
    public Group findOne(String groupId, User owner) {
        return groupRepository.findByGroupIdAndUser(groupId,owner);
    }

    @Override
    public Group create(String name, String description, Visibility visibility, User owner) {
        Group group = new Group(name, description, visibility, owner);
        group.setGroupId(UUID.randomUUID().toString());
        groupRepository.save(group);
        return group;
    }

    @Override
    public Group create(String name, String description, Visibility visibility, String userId) {
        User owner = userRepository.findByUserId(userId);
        return create(name, description, visibility, owner) ;
    }

    @Override
    public Group create(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group update(Group group, String name, String description, Visibility visibility) {

        if (group != null) {
            return update(group.getGroupId(),name, description, visibility);
        }
        return null;
    }

    @Override
    public Group update(String groupId, String name, String description, Visibility visibility) {
        Group group = findOne(groupId);
        group.setName(name);
        group.setDescription(description);
        group.setVisibility(visibility);
        return update(group);
    }

    @Override
    public Group update(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public boolean remove(Group group) {
        return remove(group.getGroupId());
    }

    @Override
    public boolean remove(String groupId) {
        Group group = findOne(groupId);
        groupRepository.delete(group);
        return isExist(group.getId());
    }

    @Override
    public List<Group> findAll(User user) {
        return groupRepository.findAllByUser(user);
    }

    @Override
    public List<Group> findAll(String userId) {
        return groupRepository.findAllByUser_UserId(userId);
    }

    @Override
    public boolean isExist(Long id) {
        return groupRepository.existsById(id);
    }
}
