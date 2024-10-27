package com.safa.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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

/*
La funcion del entity grahp es para consultar las lineas, ya que la asociacion tiene fetch LAZY
y necesita de este grafo de entidad, luego hay que ponerlo en el repository
 */

@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @Column(name = "fecha")
    private LocalDate fechaPedido;

    @OneToMany(cascade =  CascadeType.ALL,mappedBy = "pedido", fetch = FetchType.LAZY)
    private List<LinPedido> lineasPedido = new ArrayList<>();

    @Column(name = "total" )
    private Double total;

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", fechaPedido=" + fechaPedido +
                ", cliente=" + cliente.getNombre() + cliente.getApellidos() +
                ", total=" + total +
                '}';
    }


}
