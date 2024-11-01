package com.safa.saboresdecasa.repository;

import com.safa.saboresdecasa.model.Formato;
import com.safa.saboresdecasa.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Integer> {


    List<Plato> findAllByFormato(Formato formato);

    Plato findPlatoByNombre(String nombre);
}
