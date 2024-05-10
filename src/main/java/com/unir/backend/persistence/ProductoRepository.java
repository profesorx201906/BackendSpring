package com.unir.backend.persistence;

import com.unir.backend.domain.dto.ProductDTO;
import com.unir.backend.domain.repository.ProductDTORepository;
import com.unir.backend.persistence.crud.ProductoCRUDRepository;
import com.unir.backend.persistence.entity.ProductoEntity;
import com.unir.backend.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductDTORepository {
    private ProductoCRUDRepository productoCRUDRepository;

    private ProductMapper mapper;

    @Override
    public List<ProductDTO> getAll() {
        List<ProductoEntity> productos = (List<ProductoEntity>) productoCRUDRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<ProductDTO>> getByCategory(int categoryId) {
        List<ProductoEntity> productos = productoCRUDRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<ProductDTO>> getScarseProducts(int quantity) {
        Optional<List<ProductoEntity>> productos = productoCRUDRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<ProductDTO> getProduct(int productId) {
        return productoCRUDRepository.findById(productId)
                .map(producto -> mapper.toProduct(producto));
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        ProductoEntity producto = mapper.toProducto(product);
        return mapper.toProduct(productoCRUDRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCRUDRepository.deleteById(productId);
    }

}
