package com.mario.superListaApi.persistence.mapper;

import com.mario.superListaApi.domain.ListDetailItem;
import com.mario.superListaApi.persistence.entity.DetalleListaArticulo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ListDetailItemMapper {

    @Mapping(source = "id.idArticulo", target = "itemId")
    ListDetailItem toListDetailItem(DetalleListaArticulo detalleListaArticulo);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "articulo", ignore = true),
            @Mapping(target = "detalleListaA", ignore = true),
            @Mapping(target = "id.idDetalleLista", ignore = true)
    })
    DetalleListaArticulo toDetalleListaArticulo(ListDetailItem listDetailItem);
}
