package com.job.jpa.model.group;

import com.job.jpa.model.AbstractEntity;
import com.job.jpa.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GROUP_USER", uniqueConstraints = {@UniqueConstraint(columnNames={"USER_ID", "GROUP_ID"})})
@Getter
@Setter
@ToString
@NoArgsConstructor
public class GroupUser extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private PersonGroupRole role;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private PersonGroupStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    public GroupUser(User user, Group group, PersonGroupRole role, PersonGroupStatus status) {
        this.user = user;
        this.group = group;
        this.role = role;
        this.status = status;

    }
}
