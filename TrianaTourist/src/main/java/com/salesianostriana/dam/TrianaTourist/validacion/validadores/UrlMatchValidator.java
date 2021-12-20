package com.salesianostriana.dam.TrianaTourist.validacion.validadores;

import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UrlMatchValue;
import com.salesianostriana.dam.TrianaTourist.validacion.anotaciones.UrlValueMatch;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UrlMatchValidator implements ConstraintValidator<UrlMatchValue, Object> {
    private String coverPhoto;
    private String photo2;
    private String photo3;

    @Override
    public void initialize(UrlMatchValue constraintAnnotation) {
        coverPhoto = constraintAnnotation.coverPhoto();
        photo2 = constraintAnnotation.photo2();
        photo3 = constraintAnnotation.photo3();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object coverPhotoValue = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(coverPhoto);
        Object photo2Value = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photo2);
        Object photo3Value = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photo3);
        if (coverPhotoValue != null){
            return !coverPhotoValue.equals(photo2Value) && !coverPhotoValue.equals(photo3Value) && !photo2Value.equals(photo3Value);
        }else {
            return coverPhotoValue == null;
        }
    }
}
