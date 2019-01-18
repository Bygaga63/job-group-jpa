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

    Group create(String name, String description, Visibility visibility, User user);
    Group create(String name, String description, Visibility visibility, String clientId);
    Group create(Group group);

    Group update(String name, String description, Visibility visibility, User user);
    Group update(String name, String description, Visibility visibility, String clientId);
    Group update(Group group);

    boolean remove(Group group);
    boolean remove(String groupId);

    List<AppGroup> findAll(Application application);
    List<AppGroup> findAll(String clientId);

    boolean isExist(Long id);
}
