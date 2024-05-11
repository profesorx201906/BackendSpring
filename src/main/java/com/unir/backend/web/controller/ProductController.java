package com.unir.backend.web.controller;

import com.unir.backend.domain.dto.ProductDTO;
import com.unir.backend.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<ProductDTO> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Optional<ProductDTO> getProduct(@PathVariable("productId") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<ProductDTO>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public ProductDTO save (@RequestBody ProductDTO product){
        return productService.save(product);
    }
    @DeleteMapping("/delete/{productId}")
    public boolean delete(@PathVariable("productId") int productId){
        return productService.delete(productId);
    }
}
