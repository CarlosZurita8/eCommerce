package com.example.eCommerce.controller;


import com.example.eCommerce.models.Consumer;
import com.example.eCommerce.service.ConsumerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class ConsumerController {

    @Autowired
    ConsumerServiceImpl consumerService;

    //metodo para obtener la lista de los clientes
    @GetMapping
    public ResponseEntity<List<Consumer>> getAllClientes(){
        return new ResponseEntity<>(consumerService.findAll(), HttpStatus.ACCEPTED);
    }
    //Agregar o Actualizar Direccion del cliente
    /*
    @PutMapping
    public ResponseEntity<Cliente> updateDireccion(@RequestBody Direccion direccion){
        return new ResponseEntity<>(clienteService)

    }*/

}
