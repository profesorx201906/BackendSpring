package com.unir.backend.persistence.crud;


import com.unir.backend.persistence.entity.ProductoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface ProductoCRUDRepository extends
        CrudRepository<ProductoEntity,Integer> {

    //Nativo
    @Query(value="SELECT * FROM producto WHERE id_categoria=?",nativeQuery = true)
    List<ProductoEntity> findByCategoria(int idCategoria);
    //Query Method
    List<ProductoEntity> findByIdCategoria(int idCategoria);
    List<ProductoEntity> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<ProductoEntity>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);


}


