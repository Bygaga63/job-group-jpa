package com.job.jpa.model.app;

import com.job.jpa.model.AbstractEntity;
import com.job.jpa.model.group.Group;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "APP_GROUP",  uniqueConstraints = {@UniqueConstraint(columnNames={"CLIENT_ID", "GROUP_ID"})})
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AppGroup extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "CLIENT_ID")
    private Application application;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")
    private Group group;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private ApplicationGroupRole role;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ApplicationGroupStatus status;

    public AppGroup(Application application, Group group, ApplicationGroupRole role, ApplicationGroupStatus status) {
        this.application = application;
        this.group = group;
        this.role = role;
        this.status = status;
    }
}
