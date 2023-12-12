package com.example.eCommerce.service;

import com.example.eCommerce.model.Cliente;
import com.example.eCommerce.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository clienteRepo;

    @Override
    public List<Cliente> findAll() {
        return clienteRepo.findAll();
    }

    @Override
    public void save(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepo.findById(id);
    }

}
