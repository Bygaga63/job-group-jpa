package com.job.jpa.model.user;

import com.job.jpa.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "USER")
@ToString
public class User extends AbstractEntity {

    @Column(nullable = false, name = "USER_ID")
    private String userId = UUID.randomUUID().toString();


    private String name;
//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    private List<GroupUser> groupUsers = new ArrayList<>();

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}
