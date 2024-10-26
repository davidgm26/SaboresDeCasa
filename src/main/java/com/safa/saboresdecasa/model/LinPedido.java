package com.safa.saboresdecasa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valor")
    private double valor;

    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "pedido")
    private Pedido pedido ;

    @ManyToOne
    @JoinColumn(name = "plato")
    private Plato plato;

}
