package com.example.testrdsmysql.service;

import com.example.testrdsmysql.controller.advice.UserCreateException;
import com.example.testrdsmysql.controller.advice.UserUpdateException;
import com.example.testrdsmysql.data.UserRepository;
import com.example.testrdsmysql.entity.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findUsers() {
        log.info("Find all users");
        return this.repository.findUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserByUsername(@NonNull String username) {
        log.info("Find user with username: {}", username);
        return this.repository.findUserByUsername(username);
    }

    @Override
    @Transactional
    public User create(User user) {
        log.info("Saving user with username: {}", user.getUsername());
        try {
            return this.repository.save(user);
        } catch (Exception exc) {
            throw new UserCreateException(user.getUsername());
        }
    }

    @Override
    @Transactional
    public User update(User user) {
        log.info("Updating user with username: {}", user.getUsername());
        try {
            return this.repository.save(user);
        } catch (Exception exc) {
            throw new UserUpdateException(user.getUsername());
        }
    }


}
