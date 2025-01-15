package com.safa.saboresdecasa.error.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class PedidoNotFound extends EntityNotFoundException {

    public PedidoNotFound(String message) {
        super(message);
    }

    public PedidoNotFound(int id) {
        super("El pedido con el id " + id + " no existe");
    }
}
