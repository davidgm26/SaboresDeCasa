package com.safa.saboresdecasa.error;

import com.safa.saboresdecasa.error.exceptions.ClienteNotFound;
import com.safa.saboresdecasa.error.exceptions.LinPedidoNotFound;
import com.safa.saboresdecasa.error.exceptions.PedidoNotFound;
import com.safa.saboresdecasa.error.exceptions.PlatoNotFound;
import com.safa.saboresdecasa.model.Pedido;
import com.safa.saboresdecasa.model.Plato;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PlatoNotFound.class)
    public ResponseEntity<Response> handlePlatoNotFoundException(PlatoNotFound ex) {
        Response errorResponse = new Response(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PedidoNotFound.class)
    public ResponseEntity<Response> handlePedidoNotFoundException(PedidoNotFound ex) {
        Response errorResponse = new Response(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClienteNotFound.class)
    public ResponseEntity<Response> handleClienteNotFoundException(ClienteNotFound ex) {
        Response errorResponse = new Response(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LinPedidoNotFound.class)
    public ResponseEntity<Response> handleLinPedidoNotFoundException(LinPedidoNotFound ex) {
        Response errorResponse = new Response(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
