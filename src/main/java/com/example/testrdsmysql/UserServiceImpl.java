package com.example.testrdsmysql;

import com.example.testrdsmysql.data.UserRepository;
import com.example.testrdsmysql.entity.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<User> findUsers() {
        return (List<User>) this.repository.findAll();
    }

    @Override
    public Optional<User> findUserByUsername(@NonNull String username) {
        return this.repository.findUserByUsername(username);
    }

}
