package com.mario.superListaApi.domain.service;

import java.util.List;
import java.util.Optional;
import com.mario.superListaApi.domain.Item;
import com.mario.superListaApi.domain.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;


    public List<Item> getAll(){
        return itemRepository.getAll();
    }

    public Optional<Item> getItem(int itemId){
        return itemRepository.getItem(itemId);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public boolean delete(int itemId) {
        return getItem(itemId).map(item ->{
            itemRepository.delete(itemId);
            return true;
        }).orElse(false);
    }
}
