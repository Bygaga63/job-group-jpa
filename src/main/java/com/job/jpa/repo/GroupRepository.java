package com.job.jpa.repo;

import com.job.jpa.model.group.Group;
import com.job.jpa.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
    Group findByGroupId(String groupId);
    Group findByGroupIdAndUser(String groupId, User user);

    List<Group> findAllByUser(User user);
    List<Group> findAllByUser_UserId(String userId);

    boolean existsById(Long id);
}
