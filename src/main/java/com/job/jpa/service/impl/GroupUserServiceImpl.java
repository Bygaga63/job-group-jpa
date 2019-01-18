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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupUserServiceImpl implements GroupUserService {
    private GroupUsersRepository groupUsersRepository;
    private UserRepository userRepository;
    private GroupRepository groupRepository;
    
    @Override
    public GroupUser addGroupUser(User user, Group group, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus) {
        GroupUser groupUser = new GroupUser(user, group, personGroupRole, personGroupStatus);
        return groupUser;
    }

    @Override
    public GroupUser addGroupUser(String userId, String groupId, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus) {
        User user = userRepository.findByUserId(userId);
        Group group = groupRepository.findByGroupId(groupId);

        return addGroupUser(user, group, personGroupRole, personGroupStatus);
    }

    @Override
    public GroupUser updateGroupUser(User User, Group group, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus) {
        return null;
    }

    @Override
    public GroupUser updateGroupUser(String userId, String groupId, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus) {
        return null;
    }

    @Override
    public boolean removeGroupUser(User User, Group group) {
        return false;
    }

    @Override
    public boolean removeGroupUser(String userId, String groupId) {
        return false;
    }

    @Override
    public GroupUser findOneGroupUser(User User, Group group) {
        return null;
    }

    @Override
    public GroupUser findOneGroupUser(String userId, String groupId) {
        return null;
    }

    @Override
    public List<GroupUser> findAllGroupUser(User User) {
        return null;
    }

    @Override
    public List<GroupUser> findAllGroupUser(String userId) {
        return null;
    }
}
