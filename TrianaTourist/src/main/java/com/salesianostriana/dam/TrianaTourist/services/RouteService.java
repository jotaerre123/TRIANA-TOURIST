package com.salesianostriana.dam.TrianaTourist.services;

import com.salesianostriana.dam.TrianaTourist.dto.category.CreateCategoryDto;
import com.salesianostriana.dam.TrianaTourist.dto.category.GetCategoryDto;
import com.salesianostriana.dam.TrianaTourist.dto.route.CreateRouteDto;
import com.salesianostriana.dam.TrianaTourist.dto.route.GetRouteDto;
import com.salesianostriana.dam.TrianaTourist.dto.route.RouteDtoConverter;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import com.salesianostriana.dam.TrianaTourist.repos.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
    private final RouteDtoConverter routeDtoConverter;

    public ResponseEntity<List<GetRouteDto>> findAll() {

        List<Route> data = routeRepository.findAll();

        if (data.isEmpty()) {
            throw new ListEntityNotFoundException(Route.class);
        } else {

            List<GetRouteDto> result = data.stream().map(routeDtoConverter::routeToGetRouteDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(result);
        }

    }

    public ResponseEntity<List<GetRouteDto>> findById(Long id) {

        Optional<Route> data = routeRepository.findById(id);

        if (data.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Category.class);
        } else {

            List<GetRouteDto> result = data.stream().map(routeDtoConverter::routeToGetRouteDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok().body(result);
        }


    }

    public ResponseEntity<Route> save(CreateRouteDto route) {

        Route newRoute = routeDtoConverter.createRouteDtoToRoute(route);

        return ResponseEntity.status(HttpStatus.CREATED).body(routeRepository.save(newRoute));
    }

    public ResponseEntity<Route> edit(Long id, CreateRouteDto c) {

        Optional<Route> data = routeRepository.findById(id);

        if (data.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Category.class);
        } else {
            return ResponseEntity.of(routeRepository.findById(id).map(
                    m -> {
                        m.setName(c.getName());
                        routeRepository.save(m);
                        return m;
                    }
            ));
        }


    }

    public ResponseEntity<?> delete(Long id) {

        Optional<Route> data = routeRepository.findById(id);

        if (data.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Category.class);
        } else {
            routeRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }

    }
}
