package com.safa.saboresdecasa.service;

import com.safa.saboresdecasa.model.Plato;
import com.safa.saboresdecasa.repository.PlatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class PlatoService {

    private PlatoRepository platoRepository;

    public List<Plato> getPlatos() {
        return platoRepository.findAll();
    }



}
