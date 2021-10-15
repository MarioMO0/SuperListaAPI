package com.mario.superListaApi.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "detalles_lista_articulos")
public class DetalleListaArticulo {
    @EmbeddedId
    private DetalleListaArticuloPK id;

    @ManyToOne
    @MapsId("idArticulo")
    @JoinColumn(name = "articulos_id", insertable = false, updatable = false)
    private Articulo articulo;

    @ManyToOne
    @MapsId("idDetalleLista")
    @JoinColumn(name = "detalles_lista_id", insertable = false, updatable = false)
    private DetalleLista detalleListaA;

    public DetalleListaArticuloPK getId() {
        return id;
    }
    public void setId(DetalleListaArticuloPK id) {
        this.id = id;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public DetalleLista getDetalleListaA() {
        return detalleListaA;
    }

    public void setDetalleListaA(DetalleLista detalleListaA) {
        this.detalleListaA = detalleListaA;
    }
}
