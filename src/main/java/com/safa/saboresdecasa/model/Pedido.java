package com.safa.saboresdecasa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    private long idCliente;

    private Date fechaPedido;

    private List<LinPedido> lineasPedido;

}
