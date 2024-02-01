package com.example.controller;


import com.example.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;



@RestController
@AllArgsConstructor
public class ClienteController {

    ClienteService clienteService;

    //metodo para obtener la lista de los clientes


}
