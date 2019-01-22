package com.job.jpa.service;
import com.job.jpa.model.group.Group;
import com.job.jpa.model.group.GroupUser;
import com.job.jpa.model.group.PersonGroupRole;
import com.job.jpa.model.group.PersonGroupStatus;
import com.job.jpa.model.user.User;

import java.util.List;

public interface GroupUserService {
    GroupUser add(User User, Group group, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus);
    GroupUser add(String userId, String groupId, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus);
    GroupUser add(GroupUser groupUser);

    GroupUser update(User User, Group group, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus);
    GroupUser update(String userId, String groupId, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus);

    boolean remove(User User, Group group);
    boolean remove(String userId, String groupId);

    GroupUser findOne(User User, Group group);
    GroupUser findOne(String userId, String groupId);

    List<GroupUser> findAll(User User);
    List<GroupUser> findAll(String userId);
}
