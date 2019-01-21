package com.job.jpa.repo;

import com.job.jpa.model.app.AppGroup;
import com.job.jpa.model.app.Application;
import com.job.jpa.model.group.Group;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationGroupRepository extends org.springframework.data.repository.CrudRepository<AppGroup, Long> {
    AppGroup findByApplicationAndGroup(Application application, Group group);
//    @Query("select a from AppGroup a where a.application.clientId =?1 and a.group.groupId = ?2")
    AppGroup findByApplication_ClientIdAndGroup_Id(String clientId, String groupId);

    List<AppGroup> findAllByApplication(Application application);
    List<AppGroup> findAllByApplication_ClientId(String clientId);

    boolean existsById(Long id);
}
