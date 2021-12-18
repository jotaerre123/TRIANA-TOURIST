package com.salesianostriana.dam.TrianaTourist.validacion.validadores;

import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UrlValueMatch;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class UrlValueValidator implements ConstraintValidator<UrlValueMatch, Object> {

    String coverPhoto;


    @Override
    public void initialize(UrlValueMatch constraintAnnotation) {
        this.coverPhoto = constraintAnnotation.coverPhoto();

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object coverPhotoValue = PropertyAccessorFactory.forBeanPropertyAccess(o)
                .getPropertyValue(coverPhoto);

        if (coverPhotoValue != null){
            return Pattern.matches("^(?:(?<scheme>[^:\\/?#]+):)?(?:\\/\\/(?<authority>[^\\/?#]*))?(?<path>[^?#]*\\/)?(?<file>[^?#]*\\.(?<extension>[Jj][Pp][Ee]?[Gg]|[Pp][Nn][Gg]|[Gg][Ii][Ff]))(?:\\?(?<query>[^#]*))?(?:#(?<fragment>.*))?$", (CharSequence) coverPhotoValue);
        }else{
            return coverPhotoValue == null;

        }

    }
}
