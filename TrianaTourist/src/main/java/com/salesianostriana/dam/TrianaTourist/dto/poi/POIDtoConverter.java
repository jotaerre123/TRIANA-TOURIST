package com.salesianostriana.dam.TrianaTourist.dto.poi;

import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.model.POI;
import com.salesianostriana.dam.TrianaTourist.repos.CategoryRepository;
import com.salesianostriana.dam.TrianaTourist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component@RequiredArgsConstructor
public class POIDtoConverter {

    private final CategoryRepository categoryRepository;

    public GetPOIDto POIToGetPOIDto (POI p){
        return GetPOIDto.builder()
                .id(p.getId())
                .name(p.getName())
                .location(p.getLocation())
                .description(p.getDescription())
                .date(p.getDate())
                .category(p.getCategory())
                .coverPhoto(p.getCoverPhoto())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .build();
    }

    public POI createPOIToCratePOIDto (CreatePOIDto p){
        return POI.builder()
                .name(p.getName())
                .location(p.getLocation())
                .description(p.getDescription())
                .date(p.getDate())
                .category(categoryRepository.findById(p.getCategory()).get())
                .coverPhoto(p.getCoverPhoto())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .build();
    }

}
