package com.salesianostriana.dam.TrianaTourist.dto.category;

import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UniqueName;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCategoryDto {

    private Long id;

    @NotNull(message = "{category.nombre.null}")
    @NotBlank(message = "{category.nombre.blank}")
    @UniqueName(message = "No puede haber 2 iguales")
    private String name;

}
