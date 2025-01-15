package com.safa.saboresdecasa;
import com.safa.saboresdecasa.dto.PlatoDto;
import com.safa.saboresdecasa.error.exceptions.PlatoNotFound;
import com.safa.saboresdecasa.model.Formato;
import com.safa.saboresdecasa.model.Plato;
import com.safa.saboresdecasa.repository.FormatoRepository;
import com.safa.saboresdecasa.repository.PlatoRepository;
import com.safa.saboresdecasa.service.PlatoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlatoServiceIntegrationTests {

    @Mock
    private PlatoRepository platoRepository;

    @Mock
    private FormatoRepository formatoRepository;

    @InjectMocks
    private PlatoService platoService;

    private Plato p;
    private Plato p2;
    private Plato p3;
    private Formato f1;
    private Formato f2;
    private Formato f3;

    @BeforeEach
    void setUp() {
        f1 = new Formato();
        f1.setNombre("TAPA");

        f2 = new Formato();
        f2.setNombre("MEDIA");

        f3 = new Formato();
        f3.setNombre("RACION");

        // Inicializar platos
        p = new Plato();
        p.setNombre("Patatas con carne");
        p.setFormato(f1);
        p.setPrecio(2.25);

        p2 = new Plato();
        p2.setNombre("Guisantes con carne");
        p2.setFormato(f2);
        p2.setPrecio(5.75);

        p3 = new Plato();
        p3.setNombre("Puchero");
        p3.setFormato(f3);
        p3.setPrecio(12.25);
    }

    @Test
    void getAllPlatosIntegration() {
        when(platoRepository.findAll()).thenReturn(Arrays.asList(p, p2, p3));

        List<PlatoDto> result = platoService.getPlatos();

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Patatas con carne", result.get(0).getNombre());
        assertEquals("Guisantes con carne", result.get(1).getNombre());
        assertEquals("Puchero", result.get(2).getNombre());
        verify(platoRepository).findAll();
    }

    @Test
    void getPlatosByFormatoIntegration() {
        when(formatoRepository.findByNombre("TAPA")).thenReturn(f1);
        when(platoRepository.findAllByFormato(f1)).thenReturn(Arrays.asList(p));

        List<PlatoDto> result = platoService.getPlatosByFormato("tapa");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Patatas con carne", result.get(0).getNombre());
        assertEquals(2.25, result.get(0).getPrecio());
        verify(formatoRepository).findByNombre("TAPA");
        verify(platoRepository).findAllByFormato(f1);
    }

    @Test
    void getPlatoByIdIntegration() {

        p.setId(1);
        when(platoRepository.findById(1)).thenReturn(Optional.of(p));


        Plato result = platoService.getPlatoById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Patatas con carne", result.getNombre());
        assertEquals(2.25, result.getPrecio());
        verify(platoRepository).findById(1);
    }

    @Test
    void getPlatoByIdIntegrationError() {

        when(platoRepository.findById(999)).thenReturn(Optional.empty());


        assertThrows(PlatoNotFound.class, () -> platoService.getPlatoById(999));
        verify(platoRepository).findById(999);
    }

    @Test
    void getPlatoByNombreIntegration() {

        when(platoRepository.findPlatoByNombre("Patatas con carne")).thenReturn(p);


        Plato result = platoService.getPlatoByNombre("Patatas con carne");


        assertNotNull(result);
        assertEquals("Patatas con carne", result.getNombre());
        assertEquals(2.25, result.getPrecio());
        assertEquals("TAPA", result.getFormato().getNombre());
        verify(platoRepository).findPlatoByNombre("Patatas con carne");
    }

    @Test
    void getPlatosByFormatoMediaIntegration() {

        when(formatoRepository.findByNombre("MEDIA")).thenReturn(f2);
        when(platoRepository.findAllByFormato(f2)).thenReturn(Arrays.asList(p2));

        List<PlatoDto> result = platoService.getPlatosByFormato("media");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Guisantes con carne", result.get(0).getNombre());
        assertEquals(5.75, result.get(0).getPrecio());
        verify(formatoRepository).findByNombre("MEDIA");
        verify(platoRepository).findAllByFormato(f2);
    }
}