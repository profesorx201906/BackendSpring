package com.unir.backend.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.unir.backend.persistence.entity.CompraEntity;

public interface CompraCRUDRepository extends CrudRepository<CompraEntity, Integer> {
    Optional<List<CompraEntity>> findByIdCliente(String idCliente);
}

