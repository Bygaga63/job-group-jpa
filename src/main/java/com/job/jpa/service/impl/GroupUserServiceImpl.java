package com.job.jpa.service.impl;

import com.job.jpa.model.group.Group;
import com.job.jpa.model.group.GroupUser;
import com.job.jpa.model.group.PersonGroupRole;
import com.job.jpa.model.group.PersonGroupStatus;
import com.job.jpa.model.user.User;
import com.job.jpa.repo.GroupRepository;
import com.job.jpa.repo.GroupUsersRepository;
import com.job.jpa.repo.UserRepository;
import com.job.jpa.service.GroupUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupUserServiceImpl implements GroupUserService {
    private GroupUsersRepository groupUsersRepository;
    private UserRepository userRepository;
    private GroupRepository groupRepository;

    @Override
    public GroupUser add(GroupUser groupUser) {
        return groupUsersRepository.save(groupUser);
    }

    @Override
    public GroupUser add(User user, Group group, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus) {
        return add(new GroupUser(user, group, personGroupRole, personGroupStatus));
    }

    @Override
    public GroupUser add(String userId, String groupId, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus) {
        User user = userRepository.findByUserId(userId);
        Group group = groupRepository.findByGroupId(groupId);

        return add(user, group, personGroupRole, personGroupStatus);
    }

    @Override
    public GroupUser update(User user, Group group, PersonGroupRole role, PersonGroupStatus status) {
        if (group != null && user != null) {
            return update(group.getGroupId(), user.getUserId(), role, status);
        }
        return null;
    }

    @Override
    public GroupUser update(String groupId, String userId, PersonGroupRole role, PersonGroupStatus status) {
        GroupUser groupUser = findOne(groupId, userId);
        groupUser.setRole(role);
        groupUser.setStatus(status);
        return update(groupUser);
    }

    public GroupUser update(GroupUser groupUser){
        return groupUsersRepository.save(groupUser);
    }

    @Override
    public boolean remove(User user, Group group) {
        return remove(user.getUserId(), group.getGroupId());
    }

    @Override
    public boolean remove(String userId, String groupId) {
        GroupUser groupUser = findOne(userId, groupId);
        groupUsersRepository.delete(groupUser);
        return isExist(groupUser.getId());
    }

    @Override
    public GroupUser findOne(User user, Group group) {
        return groupUsersRepository.findByUserAndGroup(user, group);
    }

    @Override
    public GroupUser findOne(String userId, String groupId) {
        return groupUsersRepository.findByUser_UserIdAndGroup_GroupId(userId, groupId);
    }

    @Override
    public List<GroupUser> findAll(User user) {
        return groupUsersRepository.findAllByUser(user);
    }

    @Override
    public List<GroupUser> findAll(String userId) {
        return groupUsersRepository.findAllByUser_Id(userId);
    }

    public boolean isExist(Long id) {
        return groupUsersRepository.existsById(id);
    }
}
