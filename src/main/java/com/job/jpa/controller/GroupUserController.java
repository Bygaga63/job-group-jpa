package com.job.jpa.controller;/*
 *  21.01.2019
 *  com.job.jpa.controller
 *  jpa
 *  @author L
 */

import com.job.jpa.model.group.GroupUser;
import com.job.jpa.model.group.PersonGroupRole;
import com.job.jpa.model.group.PersonGroupStatus;
import com.job.jpa.repo.ApplicationRepository;
import com.job.jpa.repo.GroupRepository;
import com.job.jpa.repo.UserRepository;
import com.job.jpa.service.AppGroupService;
import com.job.jpa.service.GroupService;
import com.job.jpa.service.GroupUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups/user")
@AllArgsConstructor
public class GroupUserController {

    private AppGroupService appGroupService;
    private GroupService groupService;
    private GroupUserService groupUserService;
    private GroupRepository groupRepository;
    private ApplicationRepository applicationRepository;
    private UserRepository userRepository;

    @PostMapping
    public GroupUser addGroupUser(String userId, String groupId, PersonGroupRole role, PersonGroupStatus status){
        /******del*****/
        userId = getUserId(2L);
        groupId = getGroupId(1L);
        /******del*****/

        return groupUserService.add(userId, groupId, role, status);
    }

    @GetMapping
    public GroupUser getGroupUser(String userId, String groupId){
        /******del*****/
        userId = getUserId(2L);
        groupId = getGroupId(1L);
        groupUserService.add(userId, groupId, PersonGroupRole.ADMIN, PersonGroupStatus.ACTIVE);
        /******del*****/

        return groupUserService.findOne(userId,groupId);
    }

    @PutMapping
    public GroupUser editGroupUser(String userId, String groupId, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus){
        /******del*****/
        userId = getUserId(2L);
        groupId = getGroupId(1L);
        groupUserService.add(userId, groupId, PersonGroupRole.ADMIN, PersonGroupStatus.ACTIVE);
        personGroupRole = PersonGroupRole.USER;
        personGroupStatus = PersonGroupStatus.NEW;
        /******del*****/

        return groupUserService.update(userId, groupId, personGroupRole, personGroupStatus);
    }

    @DeleteMapping
    public boolean delGroupUser(String userId, String groupId){
        /******del*****/
        userId = getUserId(2L);
        groupId = getGroupId(1L);
        groupUserService.add(userId, groupId, PersonGroupRole.ADMIN, PersonGroupStatus.ACTIVE);
        /******del*****/

        return groupUserService.remove(userId, groupId);
    }

    @GetMapping("/list")
    public List<GroupUser> getGroupUserList(String userId){
        /******del*****/
        userId = getUserId(2L);
        String groupId = getGroupId(1L);
        groupUserService.add(userId, groupId, PersonGroupRole.ADMIN, PersonGroupStatus.ACTIVE);
        groupId = getGroupId(2L);
        groupUserService.add(userId, groupId, PersonGroupRole.USER, PersonGroupStatus.DENIED);
        /******del*****/

        return groupUserService.findAll(userId);
    }

    /******del getGroupId, getUserId*****/
    private String getUserId(Long id) {
        return userRepository.findOne(id).getUserId();
    }

    private String getGroupId(Long id) {
        return groupRepository.findOne(id).getGroupId();
    }

}
