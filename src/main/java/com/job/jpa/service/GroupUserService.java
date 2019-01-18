package com.job.jpa.service;
import com.job.jpa.model.group.Group;
import com.job.jpa.model.group.GroupUser;
import com.job.jpa.model.group.PersonGroupRole;
import com.job.jpa.model.group.PersonGroupStatus;
import com.job.jpa.model.user.User;

import java.util.List;

public interface GroupUserService {
    GroupUser addGroupUser( User User, Group group, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus);
    GroupUser addGroupUser(String userId, String groupId, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus);

    GroupUser updateGroupUser(User User, Group group, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus);
    GroupUser updateGroupUser(String userId, String groupId, PersonGroupRole personGroupRole, PersonGroupStatus personGroupStatus);

    boolean removeGroupUser(User User, Group group);
    boolean removeGroupUser(String userId, String groupId);

    GroupUser findOneGroupUser(User User, Group group);
    GroupUser findOneGroupUser(String userId, String groupId);

    List<GroupUser> findAllGroupUser(User User);
    List<GroupUser> findAllGroupUser(String userId);
}
