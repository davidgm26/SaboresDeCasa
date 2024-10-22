package com.safa.saboresdecasa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "plato")
public class Plato {

    @Id
    @GeneratedValue()
    private long id;

    private String nombre;

    private double precio;

    private Formato formato;
}
