package com.safa.saboresdecasa.error.exceptions;

public class PlatoNotFound extends RuntimeException {
    public PlatoNotFound(String message) {
        super(message);
    }

    public PlatoNotFound(int id) {
        super("El plato con el id: " + id + " no existe.");
    }

}
