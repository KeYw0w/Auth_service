package com.example.taskmanager.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
public class Role {
    @Id
    @Column
    private Long id;
    @Column
    private String role;
}
