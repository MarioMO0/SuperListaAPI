package com.mario.superListaApi.web.controller;
import java.util.List;

import com.mario.superListaApi.domain.Item;
import com.mario.superListaApi.domain.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping()
    public ResponseEntity<List<Item>> getAll(){
        return new ResponseEntity<>(itemService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable("id") int itemId){
        return itemService.getItem(itemId)
                .map(item -> new ResponseEntity<>(item,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping()
    public ResponseEntity<Item> save(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.save(item), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int itemId) {
        if ( itemService.delete(itemId)){
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
