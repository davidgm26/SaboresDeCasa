package com.safa.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Formato")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Formato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre",length = 180, nullable = false)
    private String nombre;



}

