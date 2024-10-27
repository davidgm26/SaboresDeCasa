package com.safa.saboresdecasa.repository;

import com.safa.saboresdecasa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional <Usuario> findTopByUsername(String username);

}
