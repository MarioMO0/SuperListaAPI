package com.mario.superListaApi.persistence.mapper;
import com.mario.superListaApi.domain.User;
import com.mario.superListaApi.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "nombreUsuario", target = "username"),
            @Mapping(source = "contrasena", target = "password"),
            @Mapping(source = "rol", target = "rol"),

    })
    User toUser(Usuario usuario);

    @InheritInverseConfiguration
    @Mapping(target = "listaArticulos", ignore = true)
    Usuario toUsuario(User user);
}
