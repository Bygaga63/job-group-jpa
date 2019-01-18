package com.job.jpa.repo;

import com.job.jpa.model.group.Group;
import com.job.jpa.model.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CommonRepository<Group> {
    Group findByGroupId(String groupId);
    Group findByGroupIdAndUser(String groupId, User user);
}
