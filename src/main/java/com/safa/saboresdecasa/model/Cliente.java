package com.safa.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre",nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellidos",nullable = false, length = 150)
    private String apellidos;

    @Column(name = "dni",nullable = false, length = 20)
    private String dni;

    @Column(name = "telefono",nullable = false, length = 18)
    private String telefono;

    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos = new HashSet<>();
}
