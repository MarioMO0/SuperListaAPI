package com.mario.superListaApi.domain.repository;
import com.mario.superListaApi.domain.ListDetail;

import java.util.List;
import java.util.Optional;

public interface ListDetailRepository {
    List<ListDetail> getAll();
    Optional<ListDetail> getlistDetail(int listDetailId);
    ListDetail save(ListDetail listDetail);
    void delete(int listDetailId);
}
