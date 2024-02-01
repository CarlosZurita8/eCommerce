package com.example.controller;

import com.example.entities.Cliente;
import com.example.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {


    ClienteService clienteService;

    //registrar un nuevo cliente
    @PostMapping(value = "/registro/cliente")
    public ResponseEntity<Cliente> registroCuentaCliente(@RequestBody Cliente cliente){
        //necesitaba devolver el cliente para que responda con un mensaje
        return new ResponseEntity<>(clienteService.agregarCliente(cliente),HttpStatus.CREATED);
    }



}
