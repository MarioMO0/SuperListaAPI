package com.mario.superListaApi.domain.service;

import com.mario.superListaApi.domain.UserList;
import com.mario.superListaApi.domain.repository.UserListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserListService {

    @Autowired
    UserListRepository userListRepository;

    public List<UserList> getAll(){
        return userListRepository.getAll();
    }

    public Optional<UserList> getUserList(int userListId){
        return userListRepository.getUserlist(userListId);
    }

    public UserList save(UserList userList){
        return userListRepository.save(userList);
    }

    public boolean delete(int userListId){
        return getUserList(userListId).map(userList -> {
            userListRepository.delete(userListId);
            return true;
        }).orElse(false);
    }
}
