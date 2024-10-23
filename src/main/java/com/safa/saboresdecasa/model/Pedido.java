package com.safa.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue
    private long idPedido;

    @ManyToOne()
    @JoinColumn(name = "id_pedido")
    private Cliente cliente;

    private Date fechaPedido;

    @OneToMany(cascade =  CascadeType.ALL,mappedBy = "pedido", fetch = FetchType.LAZY)
    private List<LinPedido> lineasPedido;

}
