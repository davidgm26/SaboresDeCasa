package com.safa.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@NamedEntityGraph(
        name = "Pedido.lineasPedido",
        attributeNodes = @NamedAttributeNode("lineasPedido")
)
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @Column(name = "fecha")
    private Date fechaPedido;

    @OneToMany(cascade =  CascadeType.ALL,mappedBy = "pedido", fetch = FetchType.LAZY)
    private List<LinPedido> lineasPedido = new ArrayList<>();

    @Column(name = "total" )
    private Double total;

}
