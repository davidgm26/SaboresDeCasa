package com.safa.saboresdecasa.service;

import com.safa.saboresdecasa.dto.*;
import com.safa.saboresdecasa.model.LinPedido;
import com.safa.saboresdecasa.model.Pedido;
import com.safa.saboresdecasa.model.Plato;
import com.safa.saboresdecasa.repository.LineaPedidoRepository;
import com.safa.saboresdecasa.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {

    @Autowired
    private LinPedidoService linPedidoService;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PlatoService platoService;


    public List<PedidoDto>getAllPedidos(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(PedidoDto::crearPedidoDtoFromPedido).collect(Collectors.toList());
    }


    public List<LineaDto> getLineas() {
        List<LinPedido> linPedidos = linPedidoService.findAll();
        return linPedidos.stream().map(LineaDto::createLineaDtoFromLinea).collect(Collectors.toList());
    }
    public PedidoDto findPedidoById(Integer id) {

        return PedidoDto.crearPedidoDtoFromPedido(pedidoRepository.findById(id).orElse(null));
    }

    public double calcularPedido(Pedido p) {
        double total = 0.0;
        for (LinPedido linPedido : p.getLineasPedido()) {
            total += linPedido.getValor();
        }
        return total;
    }

    public PedidoDto crearPedido(PeticionClienteDto dto) {
        Pedido pedido = new Pedido();
        pedido.setCliente(clienteService.findById(dto.getIdCliente()));
        pedido.setFechaPedido(LocalDate.now());
        pedidoRepository.save(pedido);
        double total = 0.0;
        for (CrearPedidoPlatoDto platoSolicitado : dto.getPlatos()) {
            Plato plato = platoService.getPlatoById(platoSolicitado.getIdPlato());
            double valorLinea = platoSolicitado.getCantidad() * plato.getPrecio();
            total += valorLinea;
            LineaDto lineaDto = LineaDto.builder()
                    .cantidad(platoSolicitado.getCantidad())
                    .valor(valorLinea)
                    .idplato(platoSolicitado.getIdPlato())
                    .build();
            LinPedido linPedido = linPedidoService.crearLinea(lineaDto, pedido);
            linPedido.setPedido(pedido);
            pedido.getLineasPedido().add(linPedido);
        }
        pedido.setTotal(total);
        pedidoRepository.save(pedido);
        return PedidoDto.crearPedidoDtoFromPedido(pedido);
    }

    public PedidoDto editarPedido(EditarPedidoDto dto, int id) {
        Pedido p = pedidoRepository.findPedidoById(id); //Más tarde esto lanzara una excepcion que nosotros podremos controlar y gestionar la respuesta.
        p.setTotal(0.0);
        dto.getLineas().forEach(linea -> {
                    p.getLineasPedido().forEach(lineaPedido -> {
                        if (lineaPedido.getId() == linea.getIdLinea()) {
                            LinPedido lineaP = linPedidoService.editarLinea(linea);
                            p.setTotal(lineaP.getValor()+p.getTotal());
                        }
                    });
                });
        pedidoRepository.save(p);
        return PedidoDto.crearPedidoDtoFromPedido(p);
    }

    public Pedido guardarPedido(Pedido pedido){
       return pedidoRepository.save(pedido);
    }
}


