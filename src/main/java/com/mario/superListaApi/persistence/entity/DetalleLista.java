package com.mario.superListaApi.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "detalles_lista")
public class    DetalleLista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_lista")
    private Integer idDetalleLista;

    private Double precio;

    private String descripcion;

    private Integer cantidad;

    @Column(name = "id_usuarios")
    private Integer idUsuario;

    @Column(name = "id_listas")
    private Integer idLista;

    @Column(name = "id_articulos")
    private  Integer idArticulo;


    @ManyToOne
    @JoinColumn(name = "id_usuarios", updatable = false, insertable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "detalleListaA", cascade = {CascadeType.ALL})
    private List<DetalleListaArticulo> articulos;

    @OneToMany(mappedBy = "detalleLista")
    private List<DetalleListaListas> listas;









    public List<DetalleListaListas> getListas() {
        return listas;
    }

    public void setListas(List<DetalleListaListas> listas) {
        this.listas = listas;
    }

    public Integer getIdDetalleLista() {
        return idDetalleLista;
    }


    public void setIdDetalleLista(Integer idDetalleLista) {
        this.idDetalleLista = idDetalleLista;
    }


    public Double getPrecio() {
        return precio;
    }


    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Integer getCantidad() {
        return cantidad;
    }


    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }



    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public List<DetalleListaArticulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<DetalleListaArticulo> articulos) {
        this.articulos = articulos;
    }
}
