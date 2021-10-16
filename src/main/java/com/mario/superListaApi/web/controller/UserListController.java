package com.mario.superListaApi.web.controller;

import com.mario.superListaApi.domain.UserList;
import com.mario.superListaApi.domain.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mylists")
public class UserListController {

    @Autowired
    private UserListService userListService;

    @GetMapping()
    public ResponseEntity<List<UserList>> getAll(){
        return new ResponseEntity<>(userListService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserList>getUserList(int userListId){
        return userListService.getUserList(userListId)
                .map(userList -> new ResponseEntity<>(userList, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<UserList> save(UserList userList){
        return new ResponseEntity<>(userListService.save(userList), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(int userListId){
        if (userListService.delete(userListId)){
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
