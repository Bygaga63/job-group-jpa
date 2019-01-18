package com.job.jpa.model.app;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "APP")
@Getter
@Setter
@ToString
public class Application implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Column(nullable = false, name = "client_id")
    private String clientId = UUID.randomUUID().toString();

    public Application() { }

    public Application(String name) {
        this.name = name;
    }
}
