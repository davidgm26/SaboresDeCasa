package com.safa.saboresdecasa.repository;

import com.safa.saboresdecasa.model.Formato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatoRepository extends JpaRepository<Formato, Integer> {


    Formato findByNombre(String nombre);

}
