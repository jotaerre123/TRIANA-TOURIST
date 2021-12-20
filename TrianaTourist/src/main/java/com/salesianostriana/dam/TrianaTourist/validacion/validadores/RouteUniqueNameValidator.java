package com.salesianostriana.dam.TrianaTourist.validacion.validadores;

import com.salesianostriana.dam.TrianaTourist.repos.RouteRepository;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.RouteUniqueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RouteUniqueNameValidator implements ConstraintValidator<RouteUniqueName, String>{

    @Autowired
    private RouteRepository routeRepository;


    @Override
    public void initialize(RouteUniqueName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !routeRepository.existsByName(s);
    }
}
