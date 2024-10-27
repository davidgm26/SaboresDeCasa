package com.safa.saboresdecasa.service;

import com.safa.saboresdecasa.dto.LineaDto;
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

    public LineaDto buscarLinea(int id){
        LinPedido linea =  lineaPedidoRepository.findById(id);
    return LineaDto.createLineaDtoFromLinea(linea);

    }

    public LinPedido crearLinea(LineaDto lineaDto, Pedido pedido) {
        return lineaPedidoRepository.save(LinPedido.builder()
                .plato(platoService.getPlatoById(lineaDto.getIdplato()))
                .cantidad(lineaDto.getCantidad())
                .valor(lineaDto.getCantidad() * platoService.getPlatoById(lineaDto.getIdplato()).getPrecio())
                .pedido(pedido)
                .build()
        );
    }

    public LinPedido editarLinea(LineaDto dto){
        LinPedido linea = lineaPedidoRepository.findById(dto.getIdLinea());
        linea.setCantidad(dto.getCantidad());
        linea.setPlato(platoService.getPlatoById(dto.getIdplato()));
        return lineaPedidoRepository.save(linea);
    }

    public List<LinPedido> findAll() {
        return lineaPedidoRepository.findAll();
    }
}
