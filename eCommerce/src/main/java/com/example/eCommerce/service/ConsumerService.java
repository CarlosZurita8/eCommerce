package com.example.eCommerce.service;

import com.example.eCommerce.models.Consumer;

import java.util.List;
import java.util.Optional;

public interface ConsumerService {

    //metodo para traer todos las cliente
    public List<Consumer> findAll();
    //metodo para dar de alta una cliente
    public Consumer addConsumer(Consumer consumer);
    //metodo parr eliminar un cliente
    public void deleteById(Long id);
    //metodo para encontrar un cliente
    public Optional<Consumer> findById(Long id);
}
