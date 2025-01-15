package com.safa.saboresdecasa.error.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class LinPedidoNotFound extends EntityNotFoundException {

    public LinPedidoNotFound(String message) {
        super(message);
    }

    public LinPedidoNotFound(int id) {
        super("La linea de pedido con id " + id + " no existe");
    }




}
