package com.safa.saboresdecasa.service;

import com.safa.saboresdecasa.dto.CrearLineaDto;
import com.safa.saboresdecasa.model.LinPedido;
import com.safa.saboresdecasa.model.Pedido;
import com.safa.saboresdecasa.model.Plato;
import com.safa.saboresdecasa.repository.LineaPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LinPedidoService {


    @Autowired
    private PlatoService platoService;

    @Autowired
    private LineaPedidoRepository lineaPedidoRepository;


    public LinPedido crearLinea(CrearLineaDto crearLineaDto, Pedido pedido) {
        Plato plato = platoService.getPlatoByNombre(crearLineaDto.getPlato());
        return lineaPedidoRepository.save(LinPedido.builder()
                .plato(plato)
                .cantidad(crearLineaDto.getCantidad())
                .valor(crearLineaDto.getCantidad() * plato.getPrecio())
                .pedido(pedido)
                .build()
        );
    }

    public List<LinPedido> findAll() {
        return lineaPedidoRepository.findAll();
    }
}
