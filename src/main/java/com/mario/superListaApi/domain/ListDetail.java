package com.mario.superListaApi.domain;

import java.util.List;

public class ListDetail {
    private int detailListId;
    private double price;
    private String description;
    private int quantity;
    private  int userId;
    private int userListId;
    private int itemId;
    private List<ListDetailItem> items;
    private List<ListDetailUserList> lists;




    public int getDetailListId() {
        return detailListId;
    }
    public void setDetailListId(int detailListId) {
        this.detailListId = detailListId;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserListId() {
        return userListId;
    }

    public void setUserListId(int userListId) {
        this.userListId = userListId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public List<ListDetailItem> getItems() {
        return items;
    }

    public void setItems(List<ListDetailItem> items) {
        this.items = items;
    }

    public List<ListDetailUserList> getLists() {
        return lists;
    }

    public void setLists(List<ListDetailUserList> lists) {
        this.lists = lists;
    }
}
