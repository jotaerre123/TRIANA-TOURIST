package com.salesianostriana.dam.TrianaTourist.controller;

import com.salesianostriana.dam.TrianaTourist.dto.route.CreateRouteDto;
import com.salesianostriana.dam.TrianaTourist.dto.route.GetRouteDto;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import com.salesianostriana.dam.TrianaTourist.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;

    @GetMapping("/")
    public ResponseEntity<List<GetRouteDto>> findAll(){
        return routeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<GetRouteDto>> findOne(@PathVariable("id") Long id){
        return routeService.findById(id);
    }

    @PostMapping("/interes")
    public ResponseEntity<Route> create(@Valid@RequestBody CreateRouteDto createRouteDto){
        return routeService.save(createRouteDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Route> edit(@PathVariable("id") Long id, @Valid@RequestBody CreateRouteDto createRouteDto){
        return routeService.edit(id, createRouteDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        return routeService.delete(id);
    }

}
