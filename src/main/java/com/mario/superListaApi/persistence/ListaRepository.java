package com.mario.superListaApi.persistence;
import java.util.List;
import java.util.Optional;

import com.mario.superListaApi.domain.UserList;
import com.mario.superListaApi.domain.repository.UserListRepository;
import com.mario.superListaApi.persistence.crud.ListaCrudRepository;
import com.mario.superListaApi.persistence.entity.Lista;
import com.mario.superListaApi.persistence.mapper.UserListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ListaRepository implements UserListRepository {
    @Autowired
    private ListaCrudRepository listaCrudRepository;

    @Autowired
    private UserListMapper mapper;

    @Override
    public List<UserList> getAll() {
        List<Lista> listas= (List<Lista>) listaCrudRepository.findAll();
        return mapper.toUserLists(listas);
    }

    @Override
    public Optional<UserList> getUserlist(int userlistId) {
        return listaCrudRepository.findById(userlistId).map(lista -> mapper.toUserList(lista));
    }

    @Override
    public UserList save(UserList userList) {
        Lista lista= mapper.toLista(userList);
        return mapper.toUserList(listaCrudRepository.save(lista));
    }

    @Override
    public void delete(int userListId) {
        listaCrudRepository.deleteById(userListId);
    }

    /*public List<Lista> getAll(){
        return (List<Lista>) listaCrudRepository.findAll();
    }

    public Optional<Lista> getLista(int idLista){
        return listaCrudRepository.findById(idLista);
    }

    public Lista save(Lista lista) {
        return listaCrudRepository.save(lista);
    }
    public void delete(int idLista) {
        listaCrudRepository.deleteById(idLista);
    }*/
}
