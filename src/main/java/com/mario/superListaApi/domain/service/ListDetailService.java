package com.mario.superListaApi.domain.service;

import com.mario.superListaApi.domain.ListDetail;
import com.mario.superListaApi.domain.repository.ListDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListDetailService {
    @Autowired
    private ListDetailRepository listDetailRepository;

    public List<ListDetail> getAll(){
        return  listDetailRepository.getAll();
    }

    public Optional<ListDetail> getlistDetail(int listDetailId){
        return listDetailRepository.getlistDetail(listDetailId);
    }

    public ListDetail save(ListDetail listDetail){
        return listDetailRepository.save(listDetail);
    }

    public boolean delete(int listDetailId){
    return getlistDetail(listDetailId).map(listDetail -> {
        listDetailRepository.delete(listDetailId);
        return true;
    }).orElse(false);
    }
}
