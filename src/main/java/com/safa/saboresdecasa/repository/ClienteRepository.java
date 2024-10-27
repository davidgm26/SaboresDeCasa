package com.safa.saboresdecasa.repository;

import com.safa.saboresdecasa.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByNombre(String nombre);
}
