package com.salesianostriana.dam.TrianaTourist.validacion.anotaciones;

import com.salesianostriana.dam.TrianaTourist.validacion.validadores.UrlMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Constraint(validatedBy = UrlMatchValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UrlMatchValue {

    String message() default "Las fotos no pueden ser iguales";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] fotosUrl();

}
