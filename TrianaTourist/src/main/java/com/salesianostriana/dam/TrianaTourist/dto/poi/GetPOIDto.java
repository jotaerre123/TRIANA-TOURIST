package com.salesianostriana.dam.TrianaTourist.dto.poi;

import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetPOIDto {

    private Long id;
    private String name;
    private String location;
    private String description;
    private Date date;
    private Category category;
    private String coverPhoto;
    private String photo2;
    private String photo3;

}
