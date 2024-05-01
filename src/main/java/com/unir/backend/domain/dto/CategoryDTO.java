package com.unir.backend.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    private int categoryID;
    private String category;
    private boolean active;
}
