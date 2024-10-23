package com.safa.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "plato")
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 150 ,nullable = false)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private double precio;


    private Formato formato;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plato",fetch = FetchType.LAZY)
    private Set<LinPedido> linPedido = new HashSet<>();
}
