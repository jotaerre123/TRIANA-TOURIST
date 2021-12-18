package com.salesianostriana.dam.TrianaTourist.controller;

import com.salesianostriana.dam.TrianaTourist.dto.poi.CreatePOIDto;
import com.salesianostriana.dam.TrianaTourist.dto.poi.GetPOIDto;
import com.salesianostriana.dam.TrianaTourist.model.POI;
import com.salesianostriana.dam.TrianaTourist.services.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class POIController {

    private final POIService poiService;

    @GetMapping("/")
    public ResponseEntity<List<GetPOIDto>> findAll(){
        return poiService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<GetPOIDto>> findOne(@PathVariable("id") Long id){
        return poiService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<POI> create(@Valid @RequestBody CreatePOIDto createPOIDto){
        return poiService.save(createPOIDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<POI> edit(@PathVariable("id") Long id, @Valid @RequestBody CreatePOIDto createPOIDto){
        return poiService.edit(id, createPOIDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        return poiService.delete(id);
    }

}
