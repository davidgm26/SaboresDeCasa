package com.safa.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue()
    private UUID id;

    private String nombre;

    private String apellidos;

    private String dni;

    private String telefono;
    @OneToMany(mappedBy = "pedido")
    private List<Pedido> pedidos;
}
