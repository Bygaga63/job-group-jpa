package com.job.jpa.service;/*
 *  21.01.2019
 *  com.job.jpa.service
 *  jpa
 *  @author L
 */

import com.job.jpa.model.user.User;

public interface UserService {
    User findOne(String userId);

    boolean isExist(Long id);
}
