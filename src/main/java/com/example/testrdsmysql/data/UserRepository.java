package com.example.testrdsmysql.data;

import com.example.testrdsmysql.entity.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @EntityGraph(value = "User.roles")
    Optional<User> findUserByUsername(@NonNull String username);

    @Query(value = "SELECT DISTINCT u FROM users u")
    @EntityGraph(value = "User.roles")
    List<User> findUsers();

}
