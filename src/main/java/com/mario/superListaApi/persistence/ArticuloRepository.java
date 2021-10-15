package com.mario.superListaApi.persistence;
import java.util.List;
import java.util.Optional;

import com.mario.superListaApi.domain.Item;
import com.mario.superListaApi.domain.repository.ItemRepository;
import com.mario.superListaApi.persistence.crud.ArticuloCrudRepository;
import com.mario.superListaApi.persistence.entity.Articulo;
import com.mario.superListaApi.persistence.mapper.ItemMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ArticuloRepository implements ItemRepository {
    @Autowired
    private ArticuloCrudRepository articuloCrudRepository;

    @Autowired
    private ItemMapper mapper;

    //metodo que regresa la lista completa de todos los articulos
    @Override
    public List<Item> getAll(){
        List<Articulo> articulos= (List<Articulo>) articuloCrudRepository.findAll();
        return mapper.toListItem(articulos);
    }


    //metodo que regresa solo 1 articulo filtrado por id
    public Optional<Item> getItem(int itemId){
        return  articuloCrudRepository.findById(itemId).map(articulo -> mapper.toItem(articulo));

    }


    public Item save(Item item) {
        Articulo articulo= mapper.toArticulo(item);
        return mapper.toItem(articuloCrudRepository.save(articulo));
    }



    public void delete(int itemId) {
        articuloCrudRepository.deleteById(itemId);
    }
}
