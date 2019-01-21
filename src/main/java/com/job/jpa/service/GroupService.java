package com.job.jpa.service;

import com.job.jpa.model.app.AppGroup;
import com.job.jpa.model.app.Application;
import com.job.jpa.model.group.Group;
import com.job.jpa.model.group.Visibility;
import com.job.jpa.model.user.User;

import java.util.List;

public interface GroupService {
    Group findOne(String groupId);
    Group findOne(String groupId, User owner);

    Group create(String name, String description, Visibility visibility, User owner);
    Group create(String name, String description, Visibility visibility, String userId);
    Group create(Group group);

    Group update(Group group, String name, String description, Visibility visibility);
    Group update(String groupId, String name, String description, Visibility visibility);
    Group update(Group group);

    boolean remove(Group group);
    boolean remove(String groupId);

    List<Group> findAll(User user);
    List<Group> findAll(String userId);

    boolean isExist(Long id);
}
