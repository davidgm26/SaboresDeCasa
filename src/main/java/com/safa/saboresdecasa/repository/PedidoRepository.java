package com.safa.saboresdecasa.repository;

import com.safa.saboresdecasa.model.Pedido;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {


    @Query("SELECT p FROM Pedido p LEFT JOIN FETCH p.lineasPedido WHERE p.id = :id")
    @EntityGraph(
            value = "Pedido.lineasPedido",
            type = EntityGraph.EntityGraphType.LOAD
    )
    Pedido findPedidoById(int id);


    @EntityGraph(
            value = "Pedido.lineasPedido",
            type = EntityGraph.EntityGraphType.LOAD

    )
    List<Pedido> findAll();


}
