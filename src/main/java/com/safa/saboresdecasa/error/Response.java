package com.safa.saboresdecasa.error;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Response {

    private String mensaje;
    private int statusCode;
    private LocalDateTime timestamp;

}
