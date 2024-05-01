package com.unir.backend.persistence;

import com.unir.backend.persistence.crud.ProductoCRUDRepository;
import com.unir.backend.persistence.entity.ProductoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCRUDRepository productoCRUDRepository;

    public List<ProductoEntity> getAll() {
        return (List<ProductoEntity>) productoCRUDRepository.findAll();
    }

    public List<ProductoEntity> getByCategoria(int idCategoria) {
        return productoCRUDRepository.findByIdCategoria(idCategoria);
        //return productoCRUDRepository.findByCategoria(idCategoria);
    }

    public Optional<List<ProductoEntity>> getScarseProducts(int quantity) {
        return productoCRUDRepository.findByCantidadStockLessThanAndEstado(quantity, true);
    }

    public Optional<ProductoEntity> getProduct(int productId) {
        return productoCRUDRepository.findById(productId);
    }

    public ProductoEntity save(ProductoEntity product) {
        return productoCRUDRepository.save(product);
    }

    public void delete(int productId) {
        productoCRUDRepository.deleteById(productId);
    }

}
