package com.mario.superListaApi.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DetalleListaArticuloPK implements Serializable {
    @Column(name = "detalles_lista_id")
    private Integer idDetalleLista;
    @Column(name = "articulos_id")
    private Integer idArticulo;

    public Integer getIdDetalleLista() {
        return idDetalleLista;
    }

    public void setIdDetalleLista(Integer idDetalleLista) {
        this.idDetalleLista = idDetalleLista;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }
}
