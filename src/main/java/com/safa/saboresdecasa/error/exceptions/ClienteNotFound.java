package com.safa.saboresdecasa.error.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class ClienteNotFound extends EntityNotFoundException {


    public ClienteNotFound(String message) {
        super(message);
    }

    public ClienteNotFound(int id) {
        super("El cliente con el id " + id + " no existe");
    }

}
