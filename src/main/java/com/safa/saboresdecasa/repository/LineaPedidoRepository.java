package com.safa.saboresdecasa.repository;

import com.safa.saboresdecasa.model.LinPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LineaPedidoRepository extends JpaRepository<LinPedido, Long> {
}
