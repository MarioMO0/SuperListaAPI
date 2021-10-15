package com.mario.superListaApi.persistence.mapper;
import java.util.List;

import com.mario.superListaApi.domain.ListDetail;
import com.mario.superListaApi.persistence.entity.DetalleLista;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.persistence.Entity;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ListDetailItemMapper.class, ListDetailUserListMapper.class})
public interface ListDetailMapper {
    @Mappings({
            @Mapping(source = "idDetalleLista", target = "detailListId"),
            @Mapping(source = "precio", target = "price"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "idLista", target = "userListId"),
            @Mapping(source = "idArticulo", target = "itemId"),
            @Mapping(source = "articulos", target = "items"),
            @Mapping(source = "listas", target = "lists"),

    })
    ListDetail toListDetail(DetalleLista detalleLista);

    List<ListDetail> toListsDetails(List<DetalleLista> detalleLista );

    @InheritInverseConfiguration
    @Mapping(target = "usuario",ignore = true)
    DetalleLista toDetalleLista(ListDetail listDetail);
}
