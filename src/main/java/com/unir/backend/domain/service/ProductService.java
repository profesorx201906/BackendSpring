package com.unir.backend.domain.service;


import com.unir.backend.domain.dto.ProductDTO;
import com.unir.backend.domain.repository.ProductDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductDTORepository productDTORepository;
    public List<ProductDTO> getAll(){
        return productDTORepository.getAll();
    }
    public Optional<ProductDTO> getProduct(int productId){
        return productDTORepository.getProduct(productId);
    }
    public  Optional<List<ProductDTO>> getByCategory(int categoryId){
        return productDTORepository.getByCategory(categoryId);
    }
    public ProductDTO save(ProductDTO product){
        return productDTORepository.save(product);
    }
    public boolean delete(int productId){
        return getProduct(productId).map(productDTO -> {
            productDTORepository.delete(productId);
            return true;
        }).orElse(false);
    }

}
