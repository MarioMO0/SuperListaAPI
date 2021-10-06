package com.mario.superListaApi.persistence.mapper;
import java.util.List;

import com.mario.superListaApi.domain.UserList;
import com.mario.superListaApi.persistence.entity.Lista;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring", uses= {UserMapper.class})
public interface UserListMapper {
    @Mappings({
            @Mapping(source = "idLista", target = "listId"),
            @Mapping(source = "nombreLista", target = "listName"),
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "usuarioId", target = "user"),
    })
    UserList toUserList(Lista lista);

    List<UserList> toUserLists(List<Lista>listas);

    @InheritInverseConfiguration
    @Mapping(target = "listaDetalles", ignore = true)
    Lista toLista(UserList userList);
}
