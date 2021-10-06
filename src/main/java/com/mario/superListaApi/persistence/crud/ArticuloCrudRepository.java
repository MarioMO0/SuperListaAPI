package com.mario.superListaApi.persistence.crud;

import com.mario.superListaApi.persistence.entity.Articulo;
import org.springframework.data.repository.CrudRepository;

public interface ArticuloCrudRepository extends CrudRepository<Articulo,Integer> {
    // en esa interfaz van a crearse todas las consultas que no esten soportadas por
    // crudrepository, ya sea con query methods o consultas nativas de sql
    /* @Query(value = "SELECT * FROM articulos WHERE id_articulo= ?", nativeQuery = true)hacer una consulta con query nativo de SQL*/

    /*List<Articulo> findAllArticuloOrderByNombreAsc();hacer una consulta con query methods de spring data JPA*/

}
