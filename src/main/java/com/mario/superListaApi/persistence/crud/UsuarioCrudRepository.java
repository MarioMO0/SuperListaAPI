package com.mario.superListaApi.persistence.crud;

import com.mario.superListaApi.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository<Usuario,Integer> {
    Usuario findBynombreUsuario(String usuario);
}
