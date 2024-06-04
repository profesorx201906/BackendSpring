package com.unir.backend.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unir.backend.domain.dto.Purchase;
import com.unir.backend.domain.repository.PurchaseDTORepository;
import com.unir.backend.persistence.crud.CompraCRUDRepository;
import com.unir.backend.persistence.entity.CompraEntity;
import com.unir.backend.persistence.mapper.PurchaseMapper;

@Repository
public class CompraRepository implements PurchaseDTORepository {

    @Autowired
    private CompraCRUDRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<CompraEntity>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        CompraEntity compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        System.out.println("bie3n");
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
