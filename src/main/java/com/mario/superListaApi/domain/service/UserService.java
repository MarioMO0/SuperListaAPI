package com.mario.superListaApi.domain.service;

import com.mario.superListaApi.domain.User;
import com.mario.superListaApi.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByName(String userName){
        return userRepository.getUserByName(userName);
    }

    public Optional<User> getUser(int userId){
        return userRepository.getUser(userId);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public boolean delete(int userId){
        return  getUser(userId).map(user ->{
            userRepository.delete(userId);
            return  true;
        }).orElse(false);
    }
}
