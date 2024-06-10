package com.unir.backend.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.backend.domain.dto.CustomerDTO;
import com.unir.backend.domain.service.CustomerService;


@RestController
@RequestMapping("/customers")
public class CustomerController {
   @Autowired
   CustomerService customerService;
    @GetMapping("/product/{productID}")
    public List<CustomerDTO> getCustomerByProduct(@PathVariable("productID") String productId) {
        return customerService.getClienteByProducto(productId);
    }

    @GetMapping("/all")
    public List<CustomerDTO> getAll() {
      return customerService.getAll();
    }
    
    
}
