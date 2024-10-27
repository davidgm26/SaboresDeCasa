package com.safa.saboresdecasa.service;

import com.safa.saboresdecasa.model.Cliente;
import com.safa.saboresdecasa.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(int id) {
        return clienteRepository.findById(id).get();
    }
}
