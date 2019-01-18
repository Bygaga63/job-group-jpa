package com.job.jpa.model.group;

import com.job.jpa.model.AbstractEntity;
import com.job.jpa.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "GROUPS")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Group extends AbstractEntity {

    @Column(name = "name", nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Visibility visibility = Visibility.PRIVATE;

    @ManyToOne
    @JoinColumn(name="owner", nullable = true)
    private User user;

    @Column(nullable = false, name = "group_id")
    private String groupId = UUID.randomUUID().toString();

    public Group(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Group(String name, String description, Visibility visibility, User user, String groupId) {
        this.name = name;
        this.description = description;
        this.visibility = visibility;
        this.user = user;
        this.groupId = groupId;
    }
}