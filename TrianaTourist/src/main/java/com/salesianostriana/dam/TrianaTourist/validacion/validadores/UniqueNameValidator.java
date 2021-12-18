package com.salesianostriana.dam.TrianaTourist.validacion.validadores;

import com.salesianostriana.dam.TrianaTourist.repos.CategoryRepository;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UniqueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void initialize(UniqueName constraintAnnotation){}
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !categoryRepository.existsByName(s);
    }
}
