package com.unir.backend.persistence;

import com.unir.backend.persistence.crud.ProductoCRUDRepository;
import com.unir.backend.persistence.entity.ProductoEntity;

import java.util.List;

public class ProductoRepository {
    private ProductoCRUDRepository productoCRUDRepository;

    public List<ProductoEntity> getAll(){
        return (List<ProductoEntity>) productoCRUDRepository.findAll();
    }

    public List<ProductoEntity> getByCategiria(int idCategoria)
    {
        return productoCRUDRepository.findByIdCategoria(idCategoria);
        //return productoCRUDRepository.findByCategoria(idCategoria);
    }
}
