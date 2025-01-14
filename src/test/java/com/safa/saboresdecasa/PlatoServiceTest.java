package com.safa.saboresdecasa;

import com.safa.saboresdecasa.dto.PlatoDto;
import com.safa.saboresdecasa.model.Formato;
import com.safa.saboresdecasa.model.Plato;
import com.safa.saboresdecasa.repository.FormatoRepository;
import com.safa.saboresdecasa.service.PlatoService;
import  static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase
public class PlatoServiceTest {


    @Autowired
    private PlatoService platoService;

    @Autowired
    private FormatoRepository formatoRepository;



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

    }

    @Test
    public void contarPlatos(){

        List<PlatoDto> platos = platoService.getPlatos();
        assert platos.size() > 0;
        assertEquals(3, platos.size());

    }

    @Test
    void buscarPlatoPorId(){

        Plato plato = platoService.getPlatoById(1);
        assertNotNull(plato);
        assertEquals(plato.getNombre(), "Patatas con carne");
    }

    @Test
    void buscarPlatoPorIdErroneo(){

        Plato plato = platoService.getPlatoById(43);
        assertNotNull(plato);
        assertEquals(plato.getNombre(), "Patatas con carne");
    }
}
