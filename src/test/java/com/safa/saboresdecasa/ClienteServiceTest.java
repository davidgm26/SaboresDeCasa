package com.safa.saboresdecasa;

import com.safa.saboresdecasa.model.Cliente;
import com.safa.saboresdecasa.repository.ClienteRepository;
import com.safa.saboresdecasa.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        Cliente c = new Cliente();
        c.setNombre("Alberto");
        c.setApellidos("Zambrano Perez");
        c.setDni("25114496W");
        c.setTelefono("682149507");

        clienteRepository.save(c);

        Cliente c1 = new Cliente();
        c1.setNombre("Manuel");
        c1.setApellidos("Zambrano Martin");
        c1.setDni("85215934C");
        c1.setTelefono("632521475");

        clienteRepository.save(c1);
    }

    @Test
    public void buscarClientePorId(){
        Cliente c = clienteService.findById(1);
        assert c != null;
        assert c.getApellidos().equals("Zambrano Perez");
        assert c.getDni().equals("25114496W");
    }

    @Test
    public void buscarClientePorIdErroneo(){
        Cliente c = clienteService.findById(2);
        assert c != null;
        assert c.getApellidos().equals("Zambrano Perez");
        assert c.getDni().equals("25114496W");
    }

    @Test
    public void buscarClientePorIdNoGuardado(){
        Cliente c = clienteService.findById(3);
    }
}
