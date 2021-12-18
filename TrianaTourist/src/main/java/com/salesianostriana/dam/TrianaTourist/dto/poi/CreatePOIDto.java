package com.salesianostriana.dam.TrianaTourist.dto.poi;

import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.LocationValueMatch;
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
                message = "{estacion.ubicacion.pattern}"
        )
})
@UrlValueMatch.List({
        @UrlValueMatch(
                coverPhoto = "coverPhoto",
                message = "URL no válida"
        )
})
public class CreatePOIDto {

    private Long id;

    @NotNull(message = "{category.nombre.null}")
    @NotBlank(message = "{category.nombre.blank}")
    private String name;

    private String location;

    private String description;

    private Date date;


    private Long category;

    @URL
    @NotNull
    private String coverPhoto;


    @Pattern(regexp = "^(?:(?<scheme>[^:\\/?#]+):)?(?:\\/\\/(?<authority>[^\\/?#]*))?(?<path>[^?#]*\\/)?(?<file>[^?#]*\\.(?<extension>[Jj][Pp][Ee]?[Gg]|[Pp][Nn][Gg]|[Gg][Ii][Ff]))(?:\\?(?<query>[^#]*))?(?:#(?<fragment>.*))?$")
    private String photo2;


    @Pattern(regexp = "^(?:(?<scheme>[^:\\/?#]+):)?(?:\\/\\/(?<authority>[^\\/?#]*))?(?<path>[^?#]*\\/)?(?<file>[^?#]*\\.(?<extension>[Jj][Pp][Ee]?[Gg]|[Pp][Nn][Gg]|[Gg][Ii][Ff]))(?:\\?(?<query>[^#]*))?(?:#(?<fragment>.*))?$")
    private String photo3;


}
