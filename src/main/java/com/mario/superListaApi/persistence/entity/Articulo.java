package com.mario.superListaApi.persistence.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "articulos")
public class Articulo {
    /*UNICOS 2 CAMPOS A MAPEAR*/
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_articulo")
    private Integer idArticulo;

    private String nombre;

    @OneToMany(mappedBy = "articulo", cascade = {CascadeType.ALL})
    private List<DetalleListaArticulo> detalleArticulos;





    /*  AQUI EMPIEZAN LOS SETTER Y GETTERS*/
    public List<DetalleListaArticulo> getDetalleArticulos() {
        return detalleArticulos;
    }

    public void setDetalleArticulos(List<DetalleListaArticulo> detalleArticulos) {
        this.detalleArticulos = detalleArticulos;
    }


    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
