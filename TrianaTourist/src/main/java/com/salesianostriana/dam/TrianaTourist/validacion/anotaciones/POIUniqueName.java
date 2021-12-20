package com.salesianostriana.dam.TrianaTourist.validacion.anotaciones;

import com.salesianostriana.dam.TrianaTourist.validacion.validadores.POIUniqueNameValidator;
import com.salesianostriana.dam.TrianaTourist.validacion.validadores.RouteUniqueNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = POIUniqueNameValidator.class)
@Documented
public @interface POIUniqueName {

    String message() default "Esta punto de interés ya existe";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

}
