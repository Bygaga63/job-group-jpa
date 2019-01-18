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
    public AppGroup addGroupApp(Group group, Application application, ApplicationGroupRole role, ApplicationGroupStatus status) {
        AppGroup appGroup = new AppGroup(application, group, role, status);
        return addGroupApp(appGroup);
    }

    @Override
    public AppGroup addGroupApp(String groupId, String clientId, ApplicationGroupRole role, ApplicationGroupStatus status) {

        Group group = groupRepository.findByGroupId(groupId);
        Application application = applicationRepository.findByClientId(clientId);

        return addGroupApp(group, application, role, status);
    }

    @Override
    public AppGroup addGroupApp(AppGroup appGroup) {
        return groupAppRepo.save(appGroup);
    }

    @Override
    public AppGroup updateGroupApp(Group group, Application application, ApplicationGroupRole role, ApplicationGroupStatus status) {
        if (group != null && application != null) {
            return updateGroupApp(group.getGroupId(), application.getClientId(), role, status);
        }
        return null;
    }

    @Override
    public AppGroup updateGroupApp(String groupId, String clientId, ApplicationGroupRole role, ApplicationGroupStatus status) {
        AppGroup appGroup = findOneGroupApp(groupId, clientId);
        appGroup.setRole(role);
        appGroup.setStatus(status);
        return updateGroupApp(appGroup);
    }

    @Override
    public AppGroup updateGroupApp(AppGroup appGroup) {
        return groupAppRepo.save(appGroup);
    }

    @Override
    public boolean removeGroupApp(Group group, Application application) {
        return removeGroupApp(group.getGroupId(), application.getClientId());
    }

    @Override
    public boolean removeGroupApp(String groupId, String clientId) {
        AppGroup appGroup = findOneGroupApp(clientId, groupId);
        groupAppRepo.delete(appGroup);
        return isExist(appGroup.getId());
    }

    @Override
    public AppGroup findOneGroupApp(Group group, Application application) {
        return groupAppRepo.findByApplicationAndGroup(application, group);
    }

    @Override
    public AppGroup findOneGroupApp(String groupId, String clientId) {
        return groupAppRepo.findByApplication_ClientIdAndGroup_Id(clientId, groupId);
    }

    @Override
    public List<AppGroup> findAllGroupApp(Application application) {
        return groupAppRepo.findAllByApplication(application);
    }

    @Override
    public List<AppGroup> findAllGroupApp(String clientId) {
        return groupAppRepo.findAllByApplication_ClientId(clientId);
    }

    @Override
    public boolean isExist(Long id) {
        return groupAppRepo.existsById(id);
    }
}
