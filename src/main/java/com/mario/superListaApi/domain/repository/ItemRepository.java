package com.mario.superListaApi.domain.repository;
import com.mario.superListaApi.domain.Item;

import java.util.List;
import java.util.Optional;
public interface ItemRepository {
    List<Item> getAll();
    Optional<Item>getItem(int itemId);
    Item save(Item item);
    void delete(int itemId);
}
