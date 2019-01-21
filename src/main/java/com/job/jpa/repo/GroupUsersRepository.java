package com.job.jpa.repo;

import com.job.jpa.model.group.Group;
import com.job.jpa.model.group.GroupUser;
import com.job.jpa.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupUsersRepository extends CrudRepository<GroupUser, Long> {
//    @Query("select g from GroupUser g where g.application.name =?1 and g.group.name =?2 and g.user.name = ?3")
//    GroupUser findGroupUsersByApplication(String addId, String groupId, String userId);

    GroupUser findByUserAndGroup(User user, Group group);
    GroupUser findByUser_UserIdAndGroup_GroupId(String userId, String groupId);

    List<GroupUser> findAllByUser(User user);
    List<GroupUser> findAllByUser_Id(String userId);

    boolean existsById(Long id);

}
