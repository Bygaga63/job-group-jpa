package com.job.jpa.repo;

import com.job.jpa.model.group.GroupUser;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupUsersRepository extends CommonRepository<GroupUser> {
//    @Query("select g from GroupUser g where g.application.name =?1 and g.group.name =?2 and g.user.name = ?3")
//    GroupUser findGroupUsersByApplication(String addId, String groupId, String userId);


}
