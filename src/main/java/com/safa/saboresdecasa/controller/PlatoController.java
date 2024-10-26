package com.safa.saboresdecasa.controller;


import com.safa.saboresdecasa.dto.PlatoDto;
import com.safa.saboresdecasa.service.PlatoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/plato")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @GetMapping("/")
    public List<PlatoDto> getPlatos() {
        return platoService.getPlatos();

    }

    @GetMapping("/{formato}")
    public List<PlatoDto> getAllPlatosFormato(@PathVariable String formato) {
        return platoService.getPlatosByFormato(formato);
    }
/*
    @PostMapping("/")
    public Plato createPlato(){
        return platoService.crearPlato();
    }*/
}
