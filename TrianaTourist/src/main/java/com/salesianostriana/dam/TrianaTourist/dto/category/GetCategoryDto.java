package com.salesianostriana.dam.TrianaTourist.dto.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCategoryDto {

    private Long id;
    private String name;

}
