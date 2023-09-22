package com.example.testrdsmysql.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@EqualsAndHashCode(exclude = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Entity( name = "users")
@NamedEntityGraph(name = "User.roles",
        attributeNodes = @NamedAttributeNode("roles")
)
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id", updatable = false, unique = true)
    private Long id;

    @Column(name = "username", updatable = false, unique = true, length = 50)
    private String username;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "position", length = 50, nullable = false)
    private String position;

    @Builder.Default
    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}
