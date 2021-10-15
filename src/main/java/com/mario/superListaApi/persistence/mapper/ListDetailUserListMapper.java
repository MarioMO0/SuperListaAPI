package com.mario.superListaApi.persistence.mapper;

import com.mario.superListaApi.domain.ListDetailUserList;
import com.mario.superListaApi.persistence.entity.DetalleListaListas;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ListDetailUserListMapper {

    @Mapping(source = "id.idDetallesLista", target = "listDetailId")
    @Mapping(source = "id.idListas", target = "userlistId")
    ListDetailUserList toListDetailUserList(DetalleListaListas detalleListaListas);

    @InheritInverseConfiguration
    @Mapping(target = "detalleLista", ignore = true)
    @Mapping(target = "lista", ignore = true)
    DetalleListaListas toDetalleListaListas(ListDetailUserList listDetailUserList);
}
