package com.unir.backend.web.controller;

import com.unir.backend.domain.dto.ProductDTO;
import com.unir.backend.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    public List<ProductDTO> getAll(){
        return productService.getAll();
    }

    public Optional<ProductDTO> getProduct(int productId){
        return productService.getProduct(productId);
    }

    public Optional<List<ProductDTO>> getByCategory(int categoryId){
        return productService.getByCategory(categoryId);
    }

    public ProductDTO save (ProductDTO product){
        return productService.save(product);
    }
    public boolean delete(int productId){
        return productService.delete(productId);
    }
}
