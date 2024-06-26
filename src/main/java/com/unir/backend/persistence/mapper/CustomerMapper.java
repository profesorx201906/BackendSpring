package com.unir.backend.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.unir.backend.domain.dto.CustomerDTO;
import com.unir.backend.persistence.entity.ClienteEntity;


@Mapper(componentModel = "spring",uses = {PurchaseMapper.class})
public interface CustomerMapper {

  @Mappings({
            @Mapping(source = "id", target = "customerID"),
            @Mapping(source = "nombre", target = "firstName"),
            @Mapping(source = "apellidos", target = "lastName"),
            @Mapping(source = "celular", target = "phone"),
            @Mapping(source = "direccion", target = "address"),
    })
    CustomerDTO toCustomer(ClienteEntity cliente);

    List<CustomerDTO> toCustomers(List<ClienteEntity> clientes);

    @InheritInverseConfiguration
    ClienteEntity toCliente(CustomerDTO category);

}
