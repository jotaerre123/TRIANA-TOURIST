package com.salesianostriana.dam.TrianaTourist.dto.route;

import com.salesianostriana.dam.TrianaTourist.model.POI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetRouteDto {

    private Long id;
    private String name;
    private List<POI> steps;

}
