package com.mario.superListaApi.domain.repository;
import com.mario.superListaApi.domain.UserE;

import java.util.List;
import java.util.Optional;
public interface UserRepository {
    UserE findByUserName(String userName);
    Optional<UserE> getUser(int userId);
    UserE save(UserE user);
    void delete(int userId);
}
