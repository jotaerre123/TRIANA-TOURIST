package com.salesianostriana.dam.TrianaTourist.validacion.validadores;


import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.LocationValueMatch;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class LocationValueMatchValidator implements ConstraintValidator<LocationValueMatch, Object> {

    String location;

    @Override
    public void initialize(LocationValueMatch constraintAnnotation) {
        this.location = constraintAnnotation.location();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue =PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(location);

        if (fieldValue != null){
            return Pattern.matches("^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$", (CharSequence) fieldValue);
        } else {

            return fieldValue == null;

        }
    }
}
