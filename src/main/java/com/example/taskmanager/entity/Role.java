package com.example.taskmanager.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Set;
@Data
@Entity
public class Role {
    @Id
    @Column
    private Long id;
    @Column
    private String role;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users;
}
