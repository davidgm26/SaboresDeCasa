package com.safa.saboresdecasa.controller;

import com.safa.saboresdecasa.dto.EditarPedidoDto;
import com.safa.saboresdecasa.dto.PedidoDto;
import com.safa.saboresdecasa.dto.PeticionClienteDto;
import com.safa.saboresdecasa.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/total/{id}")
    public Double mostrarTotal(@PathVariable int id ){
        return pedidoService.findPedidoById(id).getTotal();
    }

    @PostMapping("/")
    public PedidoDto crearPedido(@RequestBody PeticionClienteDto dto){
        return pedidoService.crearPedido(dto);
    }

    @PutMapping("/{id}")
    public PedidoDto actualizarPedido(@PathVariable int id, @RequestBody EditarPedidoDto dto){
        return pedidoService.editarPedido(dto, id);
    }
}
