package com.unir.backend.persistence.mapper;

import com.unir.backend.domain.dto.ProductDTO;
import com.unir.backend.persistence.entity.ProductoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring",uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),
    })
    ProductDTO toProduct(ProductoEntity producto);
    List<ProductDTO> toProducts(List<ProductoEntity> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    ProductoEntity toProducto(ProductDTO product);
}
