package com.mario.superListaApi.persistence;
import java.util.List;
import java.util.Optional;

import com.mario.superListaApi.domain.ListDetail;
import com.mario.superListaApi.domain.repository.ListDetailRepository;
import com.mario.superListaApi.persistence.crud.DetalleListaCrudRepository;
import com.mario.superListaApi.persistence.entity.DetalleLista;
import com.mario.superListaApi.persistence.mapper.ListDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class DetalleListaRepository implements ListDetailRepository {

    @Autowired
    private DetalleListaCrudRepository detalleListaCrudRepository;
    @Autowired
    private ListDetailMapper mapper;


    @Override
    public List<ListDetail> getAll() {
        return mapper.toListsDetails((List<DetalleLista>) detalleListaCrudRepository.findAll());
    }

    @Override
    public Optional<ListDetail> getlistDetail(int listDetailId) {
        return detalleListaCrudRepository.findById(listDetailId)
                .map(detalleLista -> mapper.toListDetail(detalleLista));
    }

    @Override
    public ListDetail save(ListDetail listDetail) {
        DetalleLista detalleLista= mapper.toDetalleLista(listDetail);
        detalleLista.getArticulos().forEach(articulo -> articulo.setDetalleListaA(detalleLista));
        detalleLista.getListas().forEach(lista -> lista.setDetalleLista(detalleLista));
        return mapper.toListDetail(detalleListaCrudRepository.save(detalleLista));
    }

    @Override
    public void delete(int listDetailId) {
    detalleListaCrudRepository.deleteById(listDetailId);
    }
}
