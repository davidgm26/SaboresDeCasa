package com.safa.saboresdecasa.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safa.saboresdecasa.model.LinPedido;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LineaDto {


    private int idLinea;
    @JsonIgnore
    private int idplato;
    private String plato;
    private String formato;
    private Integer cantidad;
    private double valor;


    public static LineaDto createLineaDtoFromLinea(LinPedido linPedido){
        return LineaDto.builder()
                .idLinea(linPedido.getId())
                .idplato(linPedido.getPlato().getId())
                .plato(linPedido.getPlato().getNombre())
                .formato(linPedido.getPlato().getFormato().getNombre())
                .cantidad(linPedido.getCantidad())
                .valor(linPedido.getValor())
                .build();
    }
}
