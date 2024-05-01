package com.unir.backend.persistence.crud;

import com.unir.backend.persistence.entity.ProductoEntity;
import org.springframework.data.repository.CrudRepository;
public interface ProductoCRUDRepository extends
        CrudRepository<ProductoEntity,Integer> {
}


