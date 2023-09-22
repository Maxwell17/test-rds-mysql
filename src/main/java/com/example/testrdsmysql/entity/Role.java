package com.example.testrdsmysql.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@EqualsAndHashCode(exclude = "users")
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "role_id", updatable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false, updatable = false, length = 25)
    @Enumerated(EnumType.STRING)
    private RoleName name;

    @Builder.Default
    @JsonBackReference
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
