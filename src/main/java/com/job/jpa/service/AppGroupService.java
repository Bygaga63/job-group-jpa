package com.job.jpa.service;

import com.job.jpa.model.app.AppGroup;
import com.job.jpa.model.app.Application;
import com.job.jpa.model.app.ApplicationGroupRole;
import com.job.jpa.model.app.ApplicationGroupStatus;
import com.job.jpa.model.group.Group;

import java.util.List;

public interface AppGroupService {

    AppGroup addGroupApp(Group group, Application application, ApplicationGroupRole role, ApplicationGroupStatus status);
    AppGroup addGroupApp(String groupId, String clientId, ApplicationGroupRole role, ApplicationGroupStatus status);
    AppGroup addGroupApp(AppGroup appGroup);

    AppGroup updateGroupApp(Group group, Application application, ApplicationGroupRole role, ApplicationGroupStatus status);
    AppGroup updateGroupApp(String groupId, String clientId, ApplicationGroupRole role, ApplicationGroupStatus status);
    AppGroup updateGroupApp(AppGroup appGroup);

    boolean removeGroupApp(Group group, Application application);
    boolean removeGroupApp(String groupId, String clientId);

    AppGroup findOneGroupApp(Group group, Application application);
    AppGroup findOneGroupApp(String groupId, String clientId);

    List<AppGroup> findAllGroupApp(Application application);
    List<AppGroup> findAllGroupApp(String clientId);


    boolean isExist(Long id);
}
