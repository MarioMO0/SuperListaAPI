package com.mario.superListaApi.persistence;
import java.util.List;
import java.util.Optional;

import com.mario.superListaApi.persistence.crud.ListaCrudRepository;
import com.mario.superListaApi.persistence.entity.Lista;
import org.springframework.stereotype.Repository;
@Repository
public class ListaRepository {
    private ListaCrudRepository listaCrudRepository;

    public List<Lista> getAll(){
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
    }
}
