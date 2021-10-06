package com.mario.superListaApi.domain.repository;
import com.mario.superListaApi.domain.User;

import java.util.List;
import java.util.Optional;
public interface UserRepository {
    Optional<User> getUserByName(String userName);
    Optional<User> getUser(int userId);
    User save(User user);
    void delete(int userId);
}
