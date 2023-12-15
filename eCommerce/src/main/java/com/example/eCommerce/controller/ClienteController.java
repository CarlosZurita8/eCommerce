package com.example.eCommerce.controller;


import com.example.eCommerce.service.ClienteService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



@RestController
@AllArgsConstructor
public class ClienteController {

    @Autowired
    ClienteService clienteService;

}
