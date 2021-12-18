package com.salesianostriana.dam.TrianaTourist.errores.excepciones;

public class ListEntityNotFoundException extends EntityNotFoundException{
    public ListEntityNotFoundException(Class clase) {
        super(String.format("No se puede encontrar los elementos de la clase %s ", clase.getName()));
    }
}
