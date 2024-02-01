package com.example.eCommerce.service;

import com.example.eCommerce.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    //metodo para traer todos las cliente
    public List<Cliente> findAll();
    //metodo para dar de alta una cliente
    public Cliente agregarCliente(Cliente cliente);
    //metodo parr eliminar un cliente
    public void deleteById(Long id);
    //metodo para encontrar un cliente
    public Optional<Cliente> findById(Long id);
}
