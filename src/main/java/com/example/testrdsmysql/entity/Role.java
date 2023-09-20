package com.example.testrdsmysql.entity;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Table(name = "ROLES")
@Entity(name = "ROLES")
public class Role {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "role_id", updatable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false, updatable = false, length = 25)
    @Enumerated(EnumType.STRING)
    private RoleName name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
