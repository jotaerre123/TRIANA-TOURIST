package com.salesianostriana.dam.TrianaTourist.dto.poi;

import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.LocationValueMatch;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.POIUniqueName;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UrlMatchValue;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UrlValueMatch;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@LocationValueMatch.List({
        @LocationValueMatch(
                location = "location",
                message = "Coordenadas mal introducidas, pruebe de nuevo"
        )
})
@UrlValueMatch.List({
        @UrlValueMatch(
                coverPhoto = "coverPhoto"
        )
})
@UrlMatchValue(fotosUrl = {"coverPhoto", "photo2", "photo3"})
public class CreatePOIDto {

    private Long id;

    @NotNull(message = "{category.nombre.null}")
    @NotBlank(message = "{category.nombre.blank}")
    @POIUniqueName
    private String name;

    private String location;

    private String description;

    private Date date;


    private Long category;

    @URL
    @NotBlank
    private String coverPhoto;


    @URL
    private String photo2;

    @URL
    private String photo3;


}
