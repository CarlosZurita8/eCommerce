package com.example.eCommerce.service;

import com.example.eCommerce.exception.ClienteException;
import com.example.eCommerce.models.Cliente;

import com.example.eCommerce.repository.ClienteRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements IClienteService{

    private ClienteRepository clienteRepo;

    @Override
    public List<Cliente> findAll() {
        return clienteRepo.findAll();
    }

    //Metodo para agregar un nuevo cliente
    @Override
    public Cliente agregarCliente(Cliente cliente) {
    	
        cliente.setFechaCreacion(LocalDateTime.now()); //fecha del momento de creacion

        Optional<Cliente> existente = clienteRepo.findByNumTelefono(cliente.getNumTelefono()); //verifico si el cliente existe buscando con su numero de telefono

        if(existente.isPresent())
            throw new ClienteException("El cliente ya existe,Intente iniciar sesion con el numero de su telefono");

        clienteRepo.save(cliente);

        return cliente;
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
