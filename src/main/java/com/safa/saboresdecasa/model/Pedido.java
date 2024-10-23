package com.safa.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "pedido")
    private Cliente cliente;

    @Column(name = "fecha")
    private Date fechaPedido;

    @OneToMany(cascade =  CascadeType.ALL,mappedBy = "pedido", fetch = FetchType.LAZY)
    private Set<LinPedido> lineasPedido = new HashSet<>();

}
