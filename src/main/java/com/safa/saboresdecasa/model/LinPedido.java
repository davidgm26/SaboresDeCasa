package com.safa.saboresdecasa.model;

import jakarta.persistence.*;
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

    @ManyToOne()
    private Pedido pedido ;

    private long idPlato;


}
