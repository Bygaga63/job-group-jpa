package com.job.jpa.controller;/*
 *  21.01.2019
 *  com.job.jpa.controller
 *  jpa
 *  @author L
 */

import com.job.jpa.dto.GroupEditRequestModel;
import com.job.jpa.model.group.Group;
import com.job.jpa.model.group.Visibility;
import com.job.jpa.model.user.User;
import com.job.jpa.repo.GroupRepository;
import com.job.jpa.repo.UserRepository;
import com.job.jpa.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@AllArgsConstructor
public class GroupController {

    private GroupService groupService;
    private GroupRepository groupRepository;
    private UserRepository userRepository;

    @PostMapping
    public Group addGroup(String name, String description, Visibility visibility, String userId){
        userId = getUserId(2L);
        /******del*****/
        return groupService.create(name, description, visibility, userId);
    }

    @DeleteMapping
    public boolean delGroup(String groupId){
        groupId = getGroupId(3L);
        /******del*****/
        return groupService.remove(groupId);
    }

    @PutMapping
    public Group editGroup(@RequestBody GroupEditRequestModel model){
        /******del*****/
        model.setGroupId(getGroupId(4L));
        /******del*****/

        return groupService.update(model.getGroupId(), model.getName(), model.getDescription(), model.getVisibility());
    }

    @GetMapping
    public Group getGroup(String groupId){
        /******del*****/
        groupId = getGroupId(3L);
        /******del*****/

        return groupService.findOne(groupId);
    }

    @GetMapping("/owner")
    public Group getGroupOwner(String groupId, User owner){
        /******del*****/
        owner = userRepository.findOne(2L);
        groupId = getGroupId(2L);
        /******del*****/

        return groupService.findOne(groupId, owner);
    }


    @GetMapping("/list")
    public List<Group> getGroupList(String userId){
        /******del*****/
        userId = getUserId(2L);
        groupService.create("name", "description", Visibility.PUBLIC, userId);
        /******del*****/

        return groupService.findAll(userId);
    }





    /******del getGroupId, getUserId*****/
    private String getUserId(Long id) {
        return userRepository.findOne(id).getUserId();
    }

    private String getGroupId(Long id) {
        return groupRepository.findOne(id).getGroupId();
    }

}
