package com.mario.superListaApi.domain;

public class UserList {
    private int listId;
    private String listName;
    private int userId;
    private UserE user;


    public int getListId() {
        return listId;
    }
    public void setListId(int listId) {
        this.listId = listId;
    }
    public String getListName() {
        return listName;
    }
    public void setListName(String listName) {
        this.listName = listName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserE getUser() {
        return user;
    }

    public void setUser(UserE user) {
        this.user = user;
    }
}
