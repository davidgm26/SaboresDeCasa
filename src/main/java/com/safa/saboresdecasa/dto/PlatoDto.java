package com.safa.saboresdecasa.dto;

import com.safa.saboresdecasa.model.Plato;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlatoDto {

    private String nombre;

    private double precio;

    private String formato;


    public static PlatoDto convertPlatotoDto(Plato plato) {
        return PlatoDto.builder().precio(plato.getPrecio())
                .nombre(plato.getNombre())
                .formato(plato.getFormato().getNombre())
                .build();
    }

}
