package com.unir.backend.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.backend.domain.dto.Purchase;
import com.unir.backend.domain.repository.PurchaseDTORepository;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseDTORepository purchaseDTORepository;

    public List<Purchase> getAll() {
        return purchaseDTORepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseDTORepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase) {
        return purchaseDTORepository.save(purchase);
    }
}