package com.example.testrdsmysql;

import com.example.testrdsmysql.entity.User;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findUsers();

    Optional<User> findUserByUsername(@NonNull String username);

}
