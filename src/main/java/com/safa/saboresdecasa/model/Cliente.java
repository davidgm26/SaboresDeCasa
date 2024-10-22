package com.safa.saboresdecasa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    private List<Pedido> pedidos;
}
