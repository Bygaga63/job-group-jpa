package com.job.jpa.repo;

import com.job.jpa.model.app.Application;
import com.job.jpa.model.group.Group;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
    Application findByClientId(String clientId);
//    Application findOne(Group group, Application application);
}
