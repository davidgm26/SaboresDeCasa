package com.safa.saboresdecasa;

import com.safa.saboresdecasa.model.Formato;
import com.safa.saboresdecasa.model.LinPedido;
import com.safa.saboresdecasa.model.Pedido;
import com.safa.saboresdecasa.model.Plato;
import com.safa.saboresdecasa.repository.FormatoRepository;
import com.safa.saboresdecasa.repository.LineaPedidoRepository;
import com.safa.saboresdecasa.repository.PedidoRepository;
import com.safa.saboresdecasa.repository.PlatoRepository;
import com.safa.saboresdecasa.service.PedidoService;
import com.safa.saboresdecasa.service.PlatoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceIntegrationTest {

    @Mock
    private PlatoRepository platoRepository;

    @Mock
    private FormatoRepository formatoRepository;

    @Mock
    private LineaPedidoRepository lineaPedidoRepository;

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PlatoService platoService;

    @InjectMocks
    private PedidoService pedidoService;

    private Plato p;
    private Plato p2;
    private Plato p3;
    private Formato f1;
    private Formato f2;
    private Formato f3;
    private Pedido pedido;
    private LinPedido lp1;
    private LinPedido lp2;

    @BeforeEach
    void setUp() {
        // Inicializar formatos
        f1 = new Formato();
        f1.setNombre("tapa");

        f2 = new Formato();
        f2.setNombre("media");

        f3 = new Formato();
        f3.setNombre("racion");

        // Inicializar platos
        p = new Plato();
        p.setId(1);
        p.setNombre("Patatas con carne");
        p.setFormato(f1);
        p.setPrecio(2.25);

        p2 = new Plato();
        p2.setId(2);
        p2.setNombre("Guisantes con carne");
        p2.setFormato(f2);
        p2.setPrecio(5.75);

        p3 = new Plato();
        p3.setId(3);
        p3.setNombre("Puchero");
        p3.setFormato(f3);
        p3.setPrecio(12.25);

    }

    @Test
    public void buscarPedidoPorId() {

        pedido = new Pedido();
        pedido.setId(1);
        pedido.setFechaPedido(LocalDate.of(2024,4,24));
        pedido.setTotal(25.5);
        pedido.setLineasPedido(new ArrayList<>());

        lp1 = new LinPedido();
        lp1.setId(1);
        lp1.setPlato(p);
        lp1.setCantidad(1);
        lp1.setValor(p.getPrecio()*lp1.getCantidad());
        lp1.setPedido(pedido);

        lp2 = new LinPedido();
        lp2.setId(2);
        lp2.setPlato(p2);
        lp2.setCantidad(2);
        lp2.setValor(p2.getPrecio()*lp2.getCantidad());
        lp2.setPedido(pedido);

        pedido.getLineasPedido().add(lp1);
        pedido.getLineasPedido().add(lp2);

        Mockito.when(pedidoRepository.findById(1)).thenReturn(Optional.of(pedido));

        assertEquals(1,pedido.getId());



    }
}