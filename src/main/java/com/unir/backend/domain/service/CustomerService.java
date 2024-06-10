package com.unir.backend.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.backend.domain.dto.CustomerDTO;
import com.unir.backend.domain.repository.CustomerDTORepository;

@Service
public class CustomerService {
  @Autowired
  private CustomerDTORepository customerDTORepository;

  public List<CustomerDTO> getClienteByProducto(String clienteId) {
    return customerDTORepository.getClienteByProducto(clienteId);
  }

  public List<CustomerDTO> getAll() {
    return customerDTORepository.getAll();
  }

}
