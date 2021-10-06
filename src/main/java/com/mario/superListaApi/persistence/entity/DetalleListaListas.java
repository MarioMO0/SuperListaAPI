package com.mario.superListaApi.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "detalles_lista_listas")
public class DetalleListaListas {
    @EmbeddedId
    private DetalleListaListasPK id;



    @ManyToOne
    @JoinColumn(name = "detalles_lista_id", insertable = false, updatable = false)
    private DetalleLista detalleLista;

    @ManyToOne
    @JoinColumn(name = "listas_id", insertable = false, updatable = false)
    private Lista lista;



    public DetalleListaListasPK getId() {
        return id;
    }

    public void setId(DetalleListaListasPK id) {
        this.id = id;
    }

    public DetalleLista getDetalleLista() {
        return detalleLista;
    }

    public void setDetalleLista(DetalleLista detalleLista) {
        this.detalleLista = detalleLista;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
