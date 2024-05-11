package com.unir.backend.web.controller;

import com.unir.backend.domain.dto.ProductDTO;
import com.unir.backend.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") int productId) {
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable("categoryId") int categoryId) {
        if (productService.getByCategory(categoryId).get().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(productService.getByCategory(categoryId).get(), HttpStatus.OK);
        }

    }

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId) {
        if (productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
