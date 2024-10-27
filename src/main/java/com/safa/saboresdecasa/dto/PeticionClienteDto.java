package com.safa.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class PeticionClienteDto {

    private List<CrearPedidoPlatoDto> platos;
    private int idCliente;
    private LocalDate fecha;




}
