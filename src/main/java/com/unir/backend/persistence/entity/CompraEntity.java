package com.unir.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "compras")
@NoArgsConstructor
public class CompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;
    private String estado;

    @ManyToOne
    @JoinColumn(name="id_cliente",insertable = false,updatable = false)
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
    private List<ComprasProductoEntity> Productos;

    public Integer getIdCompra() {
      return idCompra;
    }

    public String getIdCliente() {
      return idCliente;
    }

    public LocalDateTime getFecha() {
      return fecha;
    }

    public String getMedioPago() {
      return medioPago;
    }

    public String getComentario() {
      return comentario;
    }

    public String getEstado() {
      return estado;
    }

    public ClienteEntity getCliente() {
      return cliente;
    }

    public List<ComprasProductoEntity> getProductos() {
      return Productos;
    }

    

}
