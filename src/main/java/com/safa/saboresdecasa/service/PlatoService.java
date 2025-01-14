package com.safa.saboresdecasa.service;

import com.safa.saboresdecasa.dto.PlatoDto;
import com.safa.saboresdecasa.model.Plato;
import com.safa.saboresdecasa.repository.FormatoRepository;
import com.safa.saboresdecasa.repository.PlatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    @Autowired
    private FormatoRepository formatoRepository;
    

    public List<PlatoDto> getPlatos() {
        List<Plato> platos = platoRepository.findAll();
        return platos.stream().map(PlatoDto::convertPlatotoDto).collect(Collectors.toList());
    }

    public List<PlatoDto> getPlatosByFormato(String formato) {
        List<Plato> platos= platoRepository.findAllByFormato(formatoRepository.findByNombre(formato.toUpperCase()));
        return platos.stream().map(PlatoDto::convertPlatotoDto).collect(Collectors.toList());
    }

    public Plato guardarPlato(Plato plato) {
        return platoRepository.save(plato);
    }

    public Plato getPlatoById(int id) {
        return platoRepository.findById(id).orElse(null);
    }

    public Plato getPlatoByNombre(String nombre) {
        return platoRepository.findPlatoByNombre(nombre);
    }
}