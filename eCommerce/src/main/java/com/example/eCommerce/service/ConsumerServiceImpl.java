package com.example.eCommerce.service;

import com.example.eCommerce.exception.ConsumerException;
import com.example.eCommerce.models.Consumer;

import com.example.eCommerce.repository.ConsumerDao;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ConsumerDao clienteRepo;

    @Override
    public List<Consumer> findAll() {
        return clienteRepo.findAll();
    }

    //Metodo para agregar un nuevo cliente
    @Override
    public Consumer addConsumer(Consumer consumer) {
    	
        consumer.setCreationDate(LocalDateTime.now()); //fecha del momento de creacion

        Optional<Consumer> existente = clienteRepo.findByMobileNo(consumer.getMobileNo()); //verifico si el cliente existe buscando con su numero de telefono

        if(existente.isPresent())
            throw new ConsumerException("El cliente ya existe,Intente con otro numero de telefono");

        clienteRepo.save(consumer);

        return consumer;
    }

    @Override
    public void deleteById(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public Optional<Consumer> findById(Long id) {
        return clienteRepo.findById(id);
    }

}
