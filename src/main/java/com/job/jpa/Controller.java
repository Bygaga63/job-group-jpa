package com.job.jpa;

import com.job.jpa.model.app.AppGroup;
import com.job.jpa.model.app.Application;
import com.job.jpa.model.group.GroupUser;
import com.job.jpa.model.user.User;
import com.job.jpa.repo.*;
import com.job.jpa.service.AppGroupService;
import com.job.jpa.service.GroupUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {
    private ApplicationRepository applicationRepository;
    private UserRepository userRepository;
    private GroupUsersRepository groupUsersRepository;
    private GroupRepository groupRepository;
    private ApplicationGroupRepository applicationGroupRepository;



    private GroupUserService userService;
    private AppGroupService appGroupService;

    @GetMapping("/user")
    public Iterable<GroupUser> userGroupList (){
        return groupUsersRepository.findAll();
    }

    @GetMapping("/app")
    public Iterable<AppGroup> appGroupList (){
        return applicationGroupRepository.findAll();
    }

    @GetMapping(path = "/add")
    public GroupUser addToGroup(){
        User user = new User("Di");
        Application application = new Application("Ka");
//        Group group = new Group("Da");

        userRepository.save(user);
        applicationRepository.save(application);
//        groupRepository.save(group);

//        GroupUser groupUser = new GroupUser(true, user, application, group);
//        return groupUsersRepository.save(null);
        return null;
    }
}
