package com.salesianostriana.dam.TrianaTourist.validacion.validadores;

import com.salesianostriana.dam.TrianaTourist.repos.POIRepository;
import com.salesianostriana.dam.TrianaTourist.repos.RouteRepository;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.POIUniqueName;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.RouteUniqueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class POIUniqueNameValidator implements ConstraintValidator<POIUniqueName, String> {
    @Autowired
    private POIRepository poiRepository;


    @Override
    public void initialize(POIUniqueName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !poiRepository.existsByName(s);
    }
}
