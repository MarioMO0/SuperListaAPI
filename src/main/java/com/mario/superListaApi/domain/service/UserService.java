package com.mario.superListaApi.domain.service;

import com.mario.superListaApi.domain.UserE;
import com.mario.superListaApi.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserE getUserByName(String userName){
        return userRepository.findByUserName(userName);
    }

    public Optional<UserE> getUser(int userId){
        return userRepository.getUser(userId);
    }

    public UserE save(UserE user){
        return userRepository.save(user);
    }

    public boolean delete(int userId){
        return  getUser(userId).map(user ->{
            userRepository.delete(userId);
            return  true;
        }).orElse(false);
    }
}
