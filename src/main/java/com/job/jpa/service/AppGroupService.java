package com.job.jpa.service;

import com.job.jpa.model.app.AppGroup;
import com.job.jpa.model.app.Application;
import com.job.jpa.model.app.ApplicationGroupRole;
import com.job.jpa.model.app.ApplicationGroupStatus;
import com.job.jpa.model.group.Group;

import java.util.List;

public interface AppGroupService {

    AppGroup add(Group group, Application application, ApplicationGroupRole role, ApplicationGroupStatus status);
    AppGroup add(String groupId, String clientId, ApplicationGroupRole role, ApplicationGroupStatus status);
    AppGroup add(AppGroup appGroup);

    AppGroup update(Group group, Application application, ApplicationGroupRole role, ApplicationGroupStatus status);
    AppGroup update(String groupId, String clientId, ApplicationGroupRole role, ApplicationGroupStatus status);
    AppGroup update(AppGroup appGroup);

    boolean remove(Group group, Application application);
    boolean remove(String groupId, String clientId);

    AppGroup findOne(Group group, Application application);
    AppGroup findOne(String groupId, String clientId);

    List<AppGroup> findAll(Application application);
    List<AppGroup> findAll(String clientId);


    boolean isExist(Long id);
}
