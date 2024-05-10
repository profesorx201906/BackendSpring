package com.unir.backend.persistence.mapper;

import com.unir.backend.domain.dto.CategoryDTO;
import com.unir.backend.persistence.entity.CategoriaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-01T18:24:35-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO toCategory(CategoriaEntity categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        if ( categoria.getIdCategoria() != null ) {
            categoryDTO.setCategoryID( categoria.getIdCategoria() );
        }
        categoryDTO.setCategory( categoria.getDescripcion() );
        if ( categoria.getEstado() != null ) {
            categoryDTO.setActive( categoria.getEstado() );
        }

        return categoryDTO;
    }

    @Override
    public CategoriaEntity toCategoria(CategoryDTO category) {
        if ( category == null ) {
            return null;
        }

        CategoriaEntity categoriaEntity = new CategoriaEntity();

        categoriaEntity.setIdCategoria( category.getCategoryID() );
        categoriaEntity.setDescripcion( category.getCategory() );
        categoriaEntity.setEstado( category.isActive() );

        return categoriaEntity;
    }
}
