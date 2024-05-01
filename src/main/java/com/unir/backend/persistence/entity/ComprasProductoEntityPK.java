package com.unir.backend.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComprasProductoEntityPK implements Serializable {
    private Integer idProducto;
    private Integer idCompra;

    @Override
    public int hashCode() {
        return Objects.hash(idCompra, idProducto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComprasProductoEntityPK that)) return false;
        return Objects.equals(idCompra, that.idCompra)
                && Objects.equals(idProducto, that.idProducto);
    }
}
