package com.unir.backend.persistence.crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unir.backend.persistence.entity.ClienteEntity;

@Repository
public interface ClienteCRUDRepository extends CrudRepository<ClienteEntity, String> {

  @Query(value = "SELECT c.* " +
      "FROM clientes c " +
      "INNER JOIN compras co on c.id=co.id_cliente " +
      "INNER JOIN compras_productos cp on cp.id_compra = co.id_compra " +
      "WHERE cp.id_producto=:productoId", nativeQuery = true)
  List<ClienteEntity> findByClienteByProducto(@Param("productoId") String productoId);
}
