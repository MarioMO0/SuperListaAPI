package com.mario.superListaApi.domain.repository;
import com.mario.superListaApi.domain.UserList;

import java.util.List;
import java.util.Optional;
public interface UserListRepository {
    List<UserList> getAll();
    Optional<UserList> getUserlist(int userlistId);
    UserList save(UserList userList);
    void delete(int userListId);
}
