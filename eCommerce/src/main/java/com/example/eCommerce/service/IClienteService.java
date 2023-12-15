package com.example.eCommerce.service;

import com.example.eCommerce.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    //metodo para traer todos las cliente
    public List<Cliente> findAll();
    //metodo para dar de alta una cliente
    public void agregarCliente(Cliente cliente);
    //metodo parr eliminar un cliente
    public void deleteById(Long id);
    //metodo para encontrar un cliente
    public Optional<Cliente> findById(Long id);
}
