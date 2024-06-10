package com.unir.backend.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unir.backend.domain.dto.CustomerDTO;
import com.unir.backend.domain.repository.CustomerDTORepository;
import com.unir.backend.persistence.crud.ClienteCRUDRepository;
import com.unir.backend.persistence.entity.ClienteEntity;
import com.unir.backend.persistence.mapper.CustomerMapper;

@Repository
public class ClienteRepository implements CustomerDTORepository {

  @Autowired
  ClienteCRUDRepository clienteCRUDRepository;

  @Autowired
  CustomerMapper mapper;

    @Override
    public List<CustomerDTO> getClienteByProducto(String idProducto) {

      List<ClienteEntity> clientes = (List<ClienteEntity>) clienteCRUDRepository.findByClienteByProducto(idProducto);
        return mapper.toCustomers(clientes);
      
    }

    @Override
    public List<CustomerDTO> getAll() {
      List<ClienteEntity> clientes = (List<ClienteEntity>) clienteCRUDRepository.findAll();
      return mapper.toCustomers(clientes);    
    }

}
