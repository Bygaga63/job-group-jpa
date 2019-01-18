package com.job.jpa.service.impl;

import com.job.jpa.model.app.AppGroup;
import com.job.jpa.model.app.Application;
import com.job.jpa.model.group.Group;
import com.job.jpa.model.group.Visibility;
import com.job.jpa.model.user.User;
import com.job.jpa.repo.GroupRepository;
import com.job.jpa.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {
    private GroupRepository groupRepository;

    @Override
    public Group findOne(String groupId) {
       return groupRepository.findByGroupId(groupId);
    }

    @Override
    public Group findOne(String groupId, User owner) {

        return null;
    }

    @Override
    public Group create(String name, String description, Visibility visibility, User user) {
        return null;
    }

    @Override
    public Group create(String name, String description, Visibility visibility, String clientId) {
        return null;
    }

    @Override
    public Group create(Group group) {
        return null;
    }

    @Override
    public Group update(String name, String description, Visibility visibility, User user) {
        return null;
    }

    @Override
    public Group update(String name, String description, Visibility visibility, String clientId) {
        return null;
    }

    @Override
    public Group update(Group group) {
        return null;
    }

    @Override
    public boolean remove(Group group) {
        return false;
    }

    @Override
    public boolean remove(String groupId) {
        return false;
    }

    @Override
    public List<AppGroup> findAll(Application application) {
        return null;
    }

    @Override
    public List<AppGroup> findAll(String clientId) {
        return null;
    }

    @Override
    public boolean isExist(Long id) {
        return false;
    }
}
