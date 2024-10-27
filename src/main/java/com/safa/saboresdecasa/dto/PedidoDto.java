package com.safa.saboresdecasa.dto;


import com.safa.saboresdecasa.model.LinPedido;
import com.safa.saboresdecasa.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PedidoDto {

    private LocalDate fecha;
    private String cliente;
    private List <LineaDto> lineas;
    private double total;

    public static PedidoDto crearPedidoDtoFromPedido(Pedido pedido){

        List<LineaDto> lineasRecibidas = new ArrayList<>();

        for (LinPedido linPedido : pedido.getLineasPedido()) {
            lineasRecibidas.add(LineaDto.createLineaDtoFromLinea(linPedido));
        }

        return PedidoDto.builder()
                .cliente(pedido.getCliente().getNombre())
                .lineas(lineasRecibidas)
                .fecha(pedido.getFechaPedido())
                .total(pedido.getTotal())
                .build();
    }
}
