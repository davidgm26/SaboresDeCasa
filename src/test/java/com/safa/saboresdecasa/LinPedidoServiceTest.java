package com.safa.saboresdecasa;

import com.safa.saboresdecasa.model.Formato;
import com.safa.saboresdecasa.model.LinPedido;
import com.safa.saboresdecasa.model.Pedido;
import com.safa.saboresdecasa.model.Plato;
import com.safa.saboresdecasa.repository.FormatoRepository;
import com.safa.saboresdecasa.repository.LineaPedidoRepository;
import com.safa.saboresdecasa.repository.PedidoRepository;
import com.safa.saboresdecasa.service.PedidoService;
import com.safa.saboresdecasa.service.PlatoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import  static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase
public class LinPedidoServiceTest {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PlatoService platoService;

    @Autowired
    private FormatoRepository formatoRepository;

    @Autowired
    private LineaPedidoRepository lineaPedidoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    @BeforeEach
    public void setUp() {

        Formato f1 = new Formato();
        f1.setNombre("tapa");

        Formato f2 = new Formato();
        f2.setNombre("media");

        Formato f3 = new Formato();
        f3.setNombre("racion");

        formatoRepository.save(f1);
        formatoRepository.save(f2);
        formatoRepository.save(f3);


        Plato p = new Plato();
        p.setNombre("Patatas con carne");
        p.setFormato(f1);
        p.setPrecio(2.25);

        Plato p2 = new Plato();
        p2.setNombre("Guisantes con carne");
        p2.setFormato(f2);
        p2.setPrecio(5.75);

        Plato p3 = new Plato();
        p3.setNombre("Puchero");
        p3.setFormato(f3);
        p3.setPrecio(12.25);

        platoService.guardarPlato(p);
        platoService.guardarPlato(p2);
        platoService.guardarPlato(p3);

        Pedido pedido = new Pedido();
        pedido.setFechaPedido(LocalDate.of(2024,4,24));
        pedido.setTotal(25.5);

        pedidoService.guardarPedido(pedido);

        LinPedido lp1 = new LinPedido();
        lp1.setPlato(p);
        lp1.setCantidad(1);
        lp1.setValor(p.getPrecio()*lp1.getCantidad());

        lineaPedidoRepository.save(lp1);

        LinPedido lp2 = new LinPedido();
        lp2.setPlato(p2);
        lp2.setCantidad(2);
        lp2.setValor(p2.getPrecio()*lp2.getCantidad());

        lineaPedidoRepository.save(lp2);



        lp1.setPedido(pedido);
        lp2.setPedido(pedido);

        lineaPedidoRepository.save(lp1);
        lineaPedidoRepository.save(lp2);

        pedido.getLineasPedido().add(lp1);
        pedido.getLineasPedido().add(lp2);

        pedidoService.guardarPedido(pedido);

    }

    @Test
    public void comprobarLineasPedido(){
        List<LinPedido> lineas = lineaPedidoRepository.findAll();
        assert !lineas.isEmpty();
        assertEquals(2, lineas.size());
    }
}
