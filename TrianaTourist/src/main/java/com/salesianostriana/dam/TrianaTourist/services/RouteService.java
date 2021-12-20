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

    public List<Route> findAll(){
        if (routeRepository.findAll().isEmpty()){
            throw new ListEntityNotFoundException(Route.class);
        }else{
            return routeRepository.findAll();
        }
    }
    public Optional<Route> findById(Long id){
        if (routeRepository.findById(id).isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(),Route.class);
        }else {
            return routeRepository.findById(id);
        }
    }

    public void save(Route route){
        routeRepository.save(route);
    }

    public ResponseEntity<Route> edit(Long id, CreateRouteDto c) {

        Optional<Route> data = routeRepository.findById(id);

        if (data.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Category.class);
        } else {
            return ResponseEntity.of(routeRepository.findById(id).map(
                    m -> {
                        m.setName(c.getName());
                        m.setSteps(c.getPoi());
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
