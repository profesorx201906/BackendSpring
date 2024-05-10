package com.unir.backend.persistence.mapper;

import com.unir.backend.domain.dto.CategoryDTO;
import com.unir.backend.persistence.entity.CategoriaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryID"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    CategoryDTO toCategory(CategoriaEntity categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    CategoriaEntity toCategoria(CategoryDTO category);
}
