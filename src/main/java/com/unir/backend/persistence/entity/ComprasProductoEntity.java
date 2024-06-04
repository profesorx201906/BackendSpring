package com.unir.backend.persistence.entity;

import jakarta.persistence.*;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "compras_productos")
@NoArgsConstructor
public class ComprasProductoEntity {
  @EmbeddedId
  private ComprasProductoEntityPK id;

  private Integer cantidad;
  private Double total;
  private Boolean estado;

  @ManyToOne
  @MapsId("idCompra")
  @JoinColumn(name = "id_compra", insertable = false, updatable = false)
  private CompraEntity compra;

  @ManyToOne
  @JoinColumn(name = "id_producto", insertable = false, updatable = false)
  private ProductoEntity producto;

  public ComprasProductoEntityPK getId() {
    return id;
  }

  public void setId(ComprasProductoEntityPK id) {
    this.id = id;
  }

  public Integer getCantidad() {
    return cantidad;
  }

  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }

  public CompraEntity getCompra() {
    return compra;
  }

  public void setCompra(CompraEntity compra) {
    this.compra = compra;
  }

  public ProductoEntity getProducto() {
    return producto;
  }

  public void setProducto(ProductoEntity producto) {
    this.producto = producto;
  }

}
