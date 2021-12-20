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

    String message() default "Las fotos no pueden coincidir";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String coverPhoto();
    String photo2();
    String photo3();

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        UrlMatchValue[] value();
    }

}
