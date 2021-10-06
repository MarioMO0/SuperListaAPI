package com.mario.superListaApi.persistence.mapper;
import java.util.List;

import com.mario.superListaApi.domain.Item;
import com.mario.superListaApi.persistence.entity.Articulo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring", uses = {ListDetailMapper.class})
public interface ItemMapper {
    @Mappings({
            @Mapping(source = "idArticulo", target = "itemId"),
            @Mapping(source = "nombre", target = "name"),
    })
    Item toItem(Articulo articulo);
    List<Item> toListItem(List<Articulo> articulos);
    @InheritInverseConfiguration
    @Mapping(target = "detalleArticulos", ignore = true)
    Articulo toArticulo(Item item);
}
