package com.unir.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "compras_productos")
@IdClass(ComprasProductoEntityPK.class)
@Getter
@Setter
@NoArgsConstructor
public class ComprasProductoEntity {
    @Id
    @Column(name = "id_compra", nullable = false)
    private Integer idCompra;

    @Id
    @Column(name = "id_producto", nullable = false)
    private Integer idProducto;

    private Integer cantidad;
    private Double total;
    private Boolean estado;
}
