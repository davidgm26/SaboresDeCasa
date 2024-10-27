package com.safa.saboresdecasa.service;

import com.safa.saboresdecasa.dto.PedidoDto;
import com.safa.saboresdecasa.model.Cliente;
import com.safa.saboresdecasa.model.Pedido;
import com.safa.saboresdecasa.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(int id) {
        return clienteRepository.findById(id).get();
    }

    public List<PedidoDto> findAllPedidos(int id) {
        List<Pedido> pedidosCliente = clienteRepository.findById(id).get().getPedidos();
        return pedidosCliente.stream().map(PedidoDto::crearPedidoDtoFromPedido).collect(Collectors.toList());
    }
}
