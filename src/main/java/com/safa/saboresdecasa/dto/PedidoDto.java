package com.safa.saboresdecasa.dto;


import com.safa.saboresdecasa.model.Cliente;
import com.safa.saboresdecasa.model.LinPedido;
import com.safa.saboresdecasa.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PedidoDto {

    private Date fecha;
    private String cliente;
    private List <CrearLineaDto> lineas;
    private double total;

    public static PedidoDto crearPedidoDtoFromPedido(Pedido pedido){

        List<CrearLineaDto> lineasRecibidas = new ArrayList<>();

        for (LinPedido linPedido : pedido.getLineasPedido()) {
            lineasRecibidas.add(CrearLineaDto.createLineaDtoFromLinea(linPedido));
        }

        return PedidoDto.builder()
                .cliente(pedido.getCliente().getNombre())
                .lineas(lineasRecibidas)
                .fecha(pedido.getFechaPedido())
                .total(pedido.getTotal())
                .build();
    }
}
