package com.mario.superListaApi.persistence;
import java.util.Optional;

import com.mario.superListaApi.domain.UserE;
import com.mario.superListaApi.domain.repository.UserRepository;
import com.mario.superListaApi.persistence.crud.UsuarioCrudRepository;
import com.mario.superListaApi.persistence.entity.Usuario;
import com.mario.superListaApi.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
@Repository
public class UsuarioRepository implements UserRepository {
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;


    @Override
    public UserE findByUserName(String userName) {
        Usuario usuario= usuarioCrudRepository.findBynombreUsuario(userName);
        return mapper.toUser(usuario);
    }

    @Override
    public Optional<UserE> getUser(int userId) {
        return usuarioCrudRepository.findById(userId).map(usuario -> mapper.toUser(usuario));
    }

    @Override
    public UserE save(UserE user) {
        Usuario usuario= mapper.toUsuario(user);
        usuario.setContrasena(encriptarPassword(usuario.getContrasena()));
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public void delete(int userId) {
        usuarioCrudRepository.deleteById(userId);
    }

    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
