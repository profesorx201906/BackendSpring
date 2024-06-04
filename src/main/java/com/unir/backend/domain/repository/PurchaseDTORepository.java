package com.unir.backend.domain.repository;

import java.util.List;
import java.util.Optional;
import com.unir.backend.domain.dto.Purchase;

public interface PurchaseDTORepository {
  List<Purchase> getAll();
  Optional<List<Purchase>> getByClient(String clientId);
  Purchase save(Purchase purchase);
}
