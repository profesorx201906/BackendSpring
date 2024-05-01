package com.unir.backend.domain.repository;

import com.unir.backend.domain.dto.ProductDTO;


import java.util.List;
import java.util.Optional;


public interface ProductDTORepository {
    List<ProductDTO> getAll();
    Optional<List<ProductDTO>> getByCategory(int categoryId);
    Optional<List<ProductDTO>> getScarseProducts(int quantity);
    Optional<ProductDTO> getProduct(int productId);
    ProductDTO save(ProductDTO product);
    void delete(int productId);
}
