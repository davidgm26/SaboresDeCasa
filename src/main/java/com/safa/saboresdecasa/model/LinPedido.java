package com.safa.saboresdecasa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "lin_pedido")
public class LinPedido {

    @Id
    @GeneratedValue()
    private long id;

    private double valor;

    private int cantidad;

    private long idPedido ;

    private long idPlato;


}
