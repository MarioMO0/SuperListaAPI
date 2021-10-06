package com.mario.superListaApi.persistence.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "listas")
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista")
    private Integer idLista;

    @Column(name = "nombre_lista")
    private String nombreLista;

    @Column(name = "usuario_id")
    private Integer idUsuario;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuarioId;

    @OneToMany(mappedBy = "lista")
    private List<DetalleListaListas> listaDetalles;










    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<DetalleListaListas> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<DetalleListaListas> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }
}
