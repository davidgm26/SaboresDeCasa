package com.safa.saboresdecasa.dto;


import com.safa.saboresdecasa.model.LinPedido;
import com.safa.saboresdecasa.model.Plato;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CrearLineaDto {

    private String plato;
    private String formato;
    private Integer cantidad;
    private double valor;


    public static CrearLineaDto createLineaDtoFromLinea(LinPedido linPedido){
        return CrearLineaDto.builder()
                .plato(linPedido.getPlato().getNombre())
                .formato(linPedido.getPlato().getFormato().getNombre())
                .cantidad(linPedido.getCantidad())
                .valor(linPedido.getValor())
                .build();
    }
}
