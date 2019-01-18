package com.job.jpa.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "USER")
@ToString
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

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
