package com.safa.saboresdecasa.service;

import com.safa.saboresdecasa.dto.CrearLineaDto;
import com.safa.saboresdecasa.dto.PedidoDto;
import com.safa.saboresdecasa.model.LinPedido;
import com.safa.saboresdecasa.model.Pedido;
import com.safa.saboresdecasa.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {

    @Autowired
    private LinPedidoService linPedidoService;
    @Autowired
    private PedidoRepository pedidoRepository;


    public List<PedidoDto>getAllPedidos(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(PedidoDto::crearPedidoDtoFromPedido).collect(Collectors.toList());
    }


    public List<CrearLineaDto> getLineas(){
        List<LinPedido> linPedidos = linPedidoService.findAll();
        return linPedidos.stream().map(CrearLineaDto::createLineaDtoFromLinea).collect(Collectors.toList());
    }
    public PedidoDto findPedidoById(Integer id) {

        return PedidoDto.crearPedidoDtoFromPedido(pedidoRepository.findById(id).orElse(null));
    }

    public double calcularPedido(Pedido pedido){
          pedido.getLineasPedido().forEach(linPedido -> {
              pedido.setTotal(pedido.getTotal() + linPedido.getValor());
          });
          return pedido.getTotal();
    }

    public Pedido crearPedido(){
        return Pedido.builder()
                .total(0.0)
                .build();
    }

    public Pedido asignarLineas(List<CrearLineaDto>lineas,Integer id){
        Pedido pedido = pedidoRepository.findPedidoById(id);
        lineas.forEach(crearLineaDto -> {
            pedido.getLineasPedido().add(linPedidoService.crearLinea(crearLineaDto,pedido));
        });
        pedido.setTotal(calcularPedido(pedido));
        return pedidoRepository.save(pedido);
    }

}
