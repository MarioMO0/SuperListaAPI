package com.mario.superListaApi.web.controller;

import com.mario.superListaApi.domain.ListDetail;
import com.mario.superListaApi.domain.service.ListDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ListDetailController {
    @Autowired
    private ListDetailService listDetailService;

    @GetMapping()
    public ResponseEntity<List<ListDetail>> getAll(){
        return new ResponseEntity<>(listDetailService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/id")
    public ResponseEntity<ListDetail> getListDetail(@PathVariable("id")int lisDetailId ){
        return listDetailService.getlistDetail(lisDetailId)
                .map(listDetail -> new ResponseEntity<>(listDetail,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping()
    public ResponseEntity<ListDetail> save(@RequestBody ListDetail listDetail){
        return  new ResponseEntity<>(listDetailService.save(listDetail), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int listDetailId){
        if(listDetailService.delete(listDetailId)){
            return  new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
