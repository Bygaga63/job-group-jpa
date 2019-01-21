package com.job.jpa.service.impl;/*
 *  21.01.2019
 *  com.job.jpa.service.impl
 *  jpa
 *  @author L
 */

import com.job.jpa.model.user.User;
import com.job.jpa.repo.UserRepository;
import com.job.jpa.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User findOne(String groupId) {
        return userRepository.findByUserId(groupId);
    }
    @Override
    public boolean isExist(Long id) {
        return userRepository.exists(id);
    }

}
