package com.mario.superListaApi.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class DetalleListaListasPK implements Serializable {
    @Column(name = "detalles_lista_id")
    private Integer idDetallesLista;
    @Column(name = "listas_id")
    private Integer idListas;

    public Integer getIdDetallesLista() {
        return idDetallesLista;
    }

    public void setIdDetallesLista(Integer idDetallesLista) {
        this.idDetallesLista = idDetallesLista;
    }

    public Integer getIdListas() {
        return idListas;
    }

    public void setIdListas(Integer idListas) {
        this.idListas = idListas;
    }
}
