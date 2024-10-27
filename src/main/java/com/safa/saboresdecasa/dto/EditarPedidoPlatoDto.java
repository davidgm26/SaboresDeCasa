package com.safa.saboresdecasa.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EditarPedidoPlatoDto {

    private int idLinea;
    private int idPlato;
    private int cantidad;
}
