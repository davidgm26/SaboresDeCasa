package com.safa.saboresdecasa.controller;


import com.safa.saboresdecasa.model.Plato;
import com.safa.saboresdecasa.service.PlatoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/plato")
public class PlatoController {

    private PlatoService platoService;

    @GetMapping("/")
    public List<Plato> getPlatos(){
        return platoService.getPlatos();
    }

/*
    @PostMapping("/")
    public Plato createPlato(){
        return platoService.crearPlato();
    }*/
}
