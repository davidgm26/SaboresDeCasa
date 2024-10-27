package com.safa.saboresdecasa.controller;

import com.safa.saboresdecasa.dto.PedidoDto;
import com.safa.saboresdecasa.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;


    @GetMapping("/{id}/pedidos")
    public List<PedidoDto> getPedidosCliente(@PathVariable int id){
       return clienteService.findAllPedidos(id);
    }
}
