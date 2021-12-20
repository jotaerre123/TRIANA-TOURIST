package com.salesianostriana.dam.TrianaTourist.validacion.validadores;

import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UrlMatchValue;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UrlValueMatch;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UrlMatchValidator implements ConstraintValidator<UrlMatchValue, Object> {
    String[] fotos;

    @Override
    public void initialize(UrlMatchValue constraintAnnotation) {
        this.fotos = constraintAnnotation.fotosUrl();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        for(int i = 0; i< fotos.length; i++) {
            Object field = PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(fotos[i]);
            for (int j = i + 1; j < fotos.length; j++) {
                Object field2 = PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(fotos[j]);
                if (field.equals(field2) ) {
                    return false;
                }
            }
        }
        return true;
    }
}
