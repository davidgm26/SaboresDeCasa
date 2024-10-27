package com.safa.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class EditarPedidoDto {

    private int clienteId;
    private List<EditarPedidoPlatoDto> lineas;
    private LocalDate fecha;

}
