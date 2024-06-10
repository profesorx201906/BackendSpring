package com.unir.backend.domain.repository;

import java.util.List;

import com.unir.backend.domain.dto.CustomerDTO;

public interface CustomerDTORepository {
  List<CustomerDTO> getClienteByProducto(String clienteId);
  List<CustomerDTO> getAll();
}
