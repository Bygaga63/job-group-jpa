package com.job.jpa.service.impl;

import com.job.jpa.model.app.AppGroup;
import com.job.jpa.model.app.Application;
import com.job.jpa.model.app.ApplicationGroupRole;
import com.job.jpa.model.app.ApplicationGroupStatus;
import com.job.jpa.model.group.Group;
import com.job.jpa.repo.ApplicationGroupRepository;
import com.job.jpa.repo.ApplicationRepository;
import com.job.jpa.repo.GroupRepository;
import com.job.jpa.service.AppGroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AppGroupServiceImpl implements AppGroupService {
    private ApplicationGroupRepository groupAppRepo;
    private GroupRepository groupRepository;
    private ApplicationRepository applicationRepository;

    @Override
    public AppGroup add(Group group, Application application, ApplicationGroupRole role, ApplicationGroupStatus status) {
        AppGroup appGroup = new AppGroup(application, group, role, status);
        return add(appGroup);
    }

    @Override
    public AppGroup add(String groupId, String clientId, ApplicationGroupRole role, ApplicationGroupStatus status) {

        Group group = groupRepository.findByGroupId(groupId);
        Application application = applicationRepository.findByClientId(clientId);

        return add(group, application, role, status);
    }

    @Override
    public AppGroup add(AppGroup appGroup) {
        return groupAppRepo.save(appGroup);
    }

    @Override
    public AppGroup update(Group group, Application application, ApplicationGroupRole role, ApplicationGroupStatus status) {
        if (group != null && application != null) {
            return update(group.getGroupId(), application.getClientId(), role, status);
        }
        return null;
    }

    @Override
    public AppGroup update(String groupId, String clientId, ApplicationGroupRole role, ApplicationGroupStatus status) {
        AppGroup appGroup = findOne(groupId, clientId);
        appGroup.setRole(role);
        appGroup.setStatus(status);
        return update(appGroup);
    }

    @Override
    public AppGroup update(AppGroup appGroup) {
        return groupAppRepo.save(appGroup);
    }

    @Override
    public boolean remove(Group group, Application application) {
        return remove(group.getGroupId(), application.getClientId());
    }

    @Override
    public boolean remove(String groupId, String clientId) {
        AppGroup appGroup = findOne(groupId, clientId);
        groupAppRepo.delete(appGroup);
        return isExist(appGroup.getId());
    }

    @Override
    public AppGroup findOne(Group group, Application application) {
        return groupAppRepo.findByApplicationAndGroup(application, group);
    }

    @Override
    public AppGroup findOne(String groupId, String clientId) {
        return groupAppRepo.findByApplication_ClientIdAndGroup_Id(clientId, groupId);
    }

    @Override
    public List<AppGroup> findAll(Application application) {
        return groupAppRepo.findAllByApplication(application);
    }

    @Override
    public List<AppGroup> findAll(String clientId) {
        return groupAppRepo.findAllByApplication_ClientId(clientId);
    }

    @Override
    public boolean isExist(Long id) {
        return groupAppRepo.existsById(id);
    }
}
