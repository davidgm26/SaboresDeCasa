package com.safa.saboresdecasa.controller;

import com.safa.saboresdecasa.dto.CrearLineaDto;
import com.safa.saboresdecasa.dto.PedidoDto;
import com.safa.saboresdecasa.model.LinPedido;
import com.safa.saboresdecasa.model.Pedido;
import com.safa.saboresdecasa.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@AllArgsConstructor
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @GetMapping("/")
    public List<PedidoDto> mostrarPedidos(){
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public PedidoDto mostrarPedidoPorId(@PathVariable int id){
        return pedidoService.findPedidoById(id);
    }
}
