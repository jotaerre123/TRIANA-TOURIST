package com.salesianostriana.dam.TrianaTourist.validacion.anotaciones;

import com.salesianostriana.dam.TrianaTourist.validacion.validadores.UniqueNameValidator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueNameValidator.class)
@Documented
public @interface UniqueName {

    String message() default "No puede haber dos con el mismo nombre.";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
