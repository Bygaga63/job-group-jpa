package com.job.jpa;

import com.job.jpa.model.app.AppGroup;
import com.job.jpa.model.app.Application;
import com.job.jpa.model.group.Group;
import com.job.jpa.model.group.GroupUser;
import com.job.jpa.model.user.User;
import com.job.jpa.repo.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class JpaApplication implements CommandLineRunner {
    private ApplicationRepository applicationRepository;
    private UserRepository userRepository;
    private GroupUsersRepository groupUsersRepository;
    private GroupRepository groupRepository;
    private ApplicationGroupRepository applicationGroupRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
//        User user = new User("kek");
//        Application application = new Application("foo");
//        Group group = new Group("bar");

        List<User> users = initUsers();
        initGroups(users);
        initApplications();


//        userRepository.save(user);
//        applicationRepository.save(application);
//        groupRepository.save(group);


//        GroupUser groupUser = new GroupUser(OWNER, ACTIVE, user, group);
//        AppGroup appGroup = new AppGroup(application, group, ADMIN, DEFAULT);

//        groupUsersRepository.save(groupUser);
//        applicationGroupRepository.save(appGroup);

        print();
    }





    public void print(){
        Long id = 1L;
        System.out.println("*********USER GROUPS*********");
        GroupUser user = groupUsersRepository.findOne(id);
        System.out.println(user);

        System.out.println("*********APP GROUPS*********");
        AppGroup app = applicationGroupRepository.findOne(id);
        System.out.println(app);
    }


    public List<User> createUserList(int amount){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            users.add(new User("USER" + i));
        }

        return users;
    }


    public List<Application> createAppList(int amount){
        List<Application> applications = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            applications.add(new Application("APP" + i));
        }

        return applications;
    }


    public List<Group> createGroupList(int amount, List<User> users){
        List<Group> groups = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            groups.add(new Group("GROUP" + i, users.get(i)));
        }

        return groups;
    }

    public List<User> initUsers(){
        List<User> userList = createUserList(10);
        userList.forEach(userRepository::save);
        return userList;
    }

    public void initApplications(){
        List<Application> applications = createAppList(3);
        applications.forEach(applicationRepository::save);
    }


    public void initGroups(List<User> users){
        List<Group> groups = createGroupList(10, users);
        groups.forEach(groupRepository::save);
    }
}

