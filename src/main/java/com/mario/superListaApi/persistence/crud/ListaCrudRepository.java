package com.mario.superListaApi.persistence.crud;

import com.mario.superListaApi.persistence.entity.Lista;
import org.springframework.data.repository.CrudRepository;

public interface ListaCrudRepository extends CrudRepository<Lista,Integer> {

}
