package com.job.jpa.controller;/*
 *  18.01.2019
 *  com.job.jpa.controller
 *  jpa
 *  @author L
 */

import com.job.jpa.model.app.AppGroup;
import com.job.jpa.model.app.ApplicationGroupRole;
import com.job.jpa.model.app.ApplicationGroupStatus;
import com.job.jpa.repo.ApplicationRepository;
import com.job.jpa.repo.GroupRepository;
import com.job.jpa.service.AppGroupService;
import com.job.jpa.service.GroupService;
import com.job.jpa.service.GroupUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/groups")
@AllArgsConstructor
public class AppGroupController {

    private AppGroupService appGroupService;
    private GroupService groupService;
    private GroupUserService groupUserService;
    private GroupRepository groupRepository;
    private ApplicationRepository applicationRepository;

    @PostMapping()
    public AppGroup addAppGroup(String clientId, String groupId, ApplicationGroupRole role, ApplicationGroupStatus status){
        /******del*****/
        groupId = getGroupId(1L);
        clientId = getClientId(1L);
        /******del*****/

        return appGroupService.add(groupId, clientId, role, status);
    }


    @DeleteMapping()
    public boolean delAppGroup(String groupId, String clientId){
        /******del*****/
        groupId = getGroupId(1L);
        clientId = getClientId(2L);
        appGroupService.add(groupId, clientId, ApplicationGroupRole.ADMIN, ApplicationGroupStatus.CUSTOM);

        String groupId2 = getGroupId(2L);
        String clientId2 = getClientId(1L);
        appGroupService.add(groupId2, clientId2, ApplicationGroupRole.ADMIN, ApplicationGroupStatus.CUSTOM);
        /******del*****/

        return appGroupService.remove(groupId, clientId);
    }

    @PutMapping
    public AppGroup editAppGroup(String groupId, String clientId, ApplicationGroupRole role, ApplicationGroupStatus status){
        /******del*****/
        role = ApplicationGroupRole.USER;
        status = ApplicationGroupStatus.DEFAULT;
        groupId = getGroupId(1L);
        clientId = getClientId(2L);
        appGroupService.add(groupId, clientId, ApplicationGroupRole.ADMIN, ApplicationGroupStatus.CUSTOM);
        /******del*****/

        return appGroupService.update(groupId, clientId, role, status);
    }

    @GetMapping
    public AppGroup getAppGroup(String groupId, String clientId){
        /******del*****/
        groupId = getGroupId(1L);
        clientId = getClientId(2L);
        appGroupService.add(groupId, clientId, ApplicationGroupRole.ADMIN, ApplicationGroupStatus.CUSTOM);
        /******del*****/

        return appGroupService.findOne(groupId, clientId);
    }

    @GetMapping("/list")
    public List<AppGroup> getAppGroupList(String clientId){
        /******del*****/
        String groupId = getGroupId(1L);
        clientId = getClientId(2L);
        appGroupService.add(groupId, clientId, ApplicationGroupRole.ADMIN, ApplicationGroupStatus.CUSTOM);

        String groupId2 = getGroupId(3L);
        String clientId2 = getClientId(2L);
        appGroupService.add(groupId2, clientId2, ApplicationGroupRole.ADMIN, ApplicationGroupStatus.CUSTOM);
        /******del*****/

        return appGroupService.findAll(clientId);
    }





    /******del getGroupId, getClientId*****/
    private String getGroupId(Long id) {
        return groupRepository.findOne(id).getGroupId();
    }


    private String getClientId(Long id) {
        return applicationRepository.findOne(id).getClientId();
    }
}
