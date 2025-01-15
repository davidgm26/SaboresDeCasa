package com.safa.saboresdecasa.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private String mensaje;
    private int statusCode;
    private LocalDateTime timestamp;

}
