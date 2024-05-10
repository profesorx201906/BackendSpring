package com.unir.backend.persistence.mapper;

import com.unir.backend.domain.dto.ProductDTO;
import com.unir.backend.persistence.entity.ProductoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-01T18:24:35-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ProductDTO toProduct(ProductoEntity producto) {
        if ( producto == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        if ( producto.getIdProducto() != null ) {
            productDTO.setProductId( producto.getIdProducto() );
        }
        productDTO.setName( producto.getNombre() );
        if ( producto.getIdCategoria() != null ) {
            productDTO.setCategoryId( producto.getIdCategoria() );
        }
        if ( producto.getPrecioVenta() != null ) {
            productDTO.setPrice( producto.getPrecioVenta() );
        }
        if ( producto.getCantidadStock() != null ) {
            productDTO.setStock( producto.getCantidadStock() );
        }
        if ( producto.getEstado() != null ) {
            productDTO.setActive( producto.getEstado() );
        }
        productDTO.setCategory( categoryMapper.toCategory( producto.getCategoria() ) );

        return productDTO;
    }

    @Override
    public List<ProductDTO> toProducts(List<ProductoEntity> productos) {
        if ( productos == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( productos.size() );
        for ( ProductoEntity productoEntity : productos ) {
            list.add( toProduct( productoEntity ) );
        }

        return list;
    }

    @Override
    public ProductoEntity toProducto(ProductDTO product) {
        if ( product == null ) {
            return null;
        }

        ProductoEntity productoEntity = new ProductoEntity();

        productoEntity.setIdProducto( product.getProductId() );
        productoEntity.setNombre( product.getName() );
        productoEntity.setIdCategoria( product.getCategoryId() );
        productoEntity.setPrecioVenta( product.getPrice() );
        productoEntity.setCantidadStock( product.getStock() );
        productoEntity.setEstado( product.isActive() );
        productoEntity.setCategoria( categoryMapper.toCategoria( product.getCategory() ) );

        return productoEntity;
    }
}
