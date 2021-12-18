package com.salesianostriana.dam.TrianaTourist.dto.category;

import com.salesianostriana.dam.TrianaTourist.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {

    public GetCategoryDto categoryToGetCategoryDto (Category c){
        return GetCategoryDto.builder()
                .id(c.getId())
                .name(c.getName())
                .build();
    }

    public Category createCategoryDtoToCategory (CreateCategoryDto c){
        return Category.builder()
                .name(c.getName())
                .build();
    }

}
