package com.example.eCommerce.controller;

import com.example.eCommerce.dto.ConsumerDto;
import com.example.eCommerce.dto.SessionDto;
import com.example.eCommerce.models.Consumer;
import com.example.eCommerce.models.UserSession;
import com.example.eCommerce.service.ConsumerServiceImpl;

import com.example.eCommerce.service.LoginLogoutServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    @Autowired
    ConsumerServiceImpl consumerService;

    @Autowired
    LoginLogoutServiceImpl loginLogoutService;


    //registrar un nuevo consumidor
    @PostMapping(value = "/registro/cliente",consumes = "application/json")
    public ResponseEntity<Consumer> registroCuentaCliente(@Valid @RequestBody Consumer consumer){
        //necesitaba devolver el cliente para que responda con un mensaje
            return new ResponseEntity<>(consumerService.addConsumer(consumer),HttpStatus.CREATED);
    }

    //inicio de sesion del cliente
    @PostMapping(value = "login/cliente",consumes = "application/json")
    public ResponseEntity<UserSession> inicioSesionCliente(@Valid @RequestBody ConsumerDto consumerDto){

            return new ResponseEntity<>(loginLogoutService.loginConsumer(consumerDto),HttpStatus.ACCEPTED);
    }
    //cierre de sesion del cliente
    @PostMapping(value = "logout/cliente",consumes = "application/json")
    public ResponseEntity<SessionDto> cierreDeSesionCLiente(@Valid @RequestBody SessionDto sessionDto){

            return new ResponseEntity<>(loginLogoutService.logoutConsumer(sessionDto),HttpStatus.ACCEPTED);
    }

}
