package com.mario.superListaApi.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuarios")
    private Integer idUsuario;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    private String contrasena;

    private String rol;


    @OneToMany(mappedBy = "usuarioId")
    private List <Lista> listas;

    @OneToMany(mappedBy = "usuario")
    private List<DetalleLista> listaArticulos;

    public List<DetalleLista> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(List<DetalleLista> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
