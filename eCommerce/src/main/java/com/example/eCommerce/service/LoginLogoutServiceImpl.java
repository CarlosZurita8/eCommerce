package com.example.eCommerce.service;

import com.example.eCommerce.dto.ConsumerDto;
import com.example.eCommerce.dto.SessionDto;
import com.example.eCommerce.exception.ConsumerNotFoundException;
import com.example.eCommerce.exception.LoginException;
import com.example.eCommerce.models.Consumer;
import com.example.eCommerce.models.UserSession;
import com.example.eCommerce.repository.ConsumerDao;
import com.example.eCommerce.repository.UserSessionDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Service
@AllArgsConstructor
public class LoginLogoutServiceImpl implements LonginLogoutService {

        @Autowired
        private UserSessionDao sessionDao;

        @Autowired
        private ConsumerDao consumerDao;

    //Metodo para iniciar sesion del cliente
    @Override
    public UserSession loginConsumer(ConsumerDto loginConsumer) {

        //verificamos que el cliente exista,buscando el usuario por su numero de telefono
        Optional<Consumer> res = consumerDao.findByMobileNo(loginConsumer.getMobileId());

        //si no existe responde con el siguiente mensaje
        if(res.isEmpty())
            throw new ConsumerNotFoundException("El cliente con el numero ingresado no existe");

        //si existe,creamos un objeto de la clase Cliente y guardamos su estado en el mismo;
        Consumer existingConsumer = res.get();

        //buscamos al usuario por su Id
        Optional<UserSession> opt  = sessionDao.findByUserId(existingConsumer.getUserId());

        //si se encuentram,cramos un objeto de la clase SesionUsuario y lo guardamos en el mismo
        if(opt.isPresent()){
            UserSession usuario = opt.get();
            //si la hora final de la sesion se antes del tiempo actuali se elimina el usuario
            if(usuario.getSessionEndTime().isBefore(LocalDateTime.now())){
                sessionDao.delete(usuario);
            }
            //sino se responde con el siguiente mensaje
            else
                throw new LoginException("El usuario esta conectado");
        }
        //verificamos si la contraseña del cliente es igual a la de login
        //si es correcto se crea un objeto de SesionUsuario y se le asigna lo siguiente
        //se le asigna el tipo de usuario y token para el inicio de sesion
        if(existingConsumer.getPassword().equals(loginConsumer.getPassword())){

                UserSession newSession = new UserSession();

                newSession.setUserId(existingConsumer.getUserId());
                newSession.setUserType("cliente");
                newSession.setSessionStartTime(LocalDateTime.now());
                newSession.setSessionEndTime(LocalDateTime.now().plusHours(1));

                UUID uuid = UUID.randomUUID();
                String token = "cliente_" + uuid.toString().split("-")[0];

                newSession.setToken(token);

                return sessionDao.save(newSession);

        }
        else {
            throw new LoginException("Contraseña incorrecta,intente de nuevo");
        }

    }
    //metodo para terminar la sesion
    @Override
    public SessionDto logoutConsumer(SessionDto sesionToken) {

        String token = sesionToken.getToken();

        checkTokenStatus(token);

        Optional<UserSession> opt = sessionDao.findByToken(token);

        if(!opt.isPresent())
                throw new LoginException("El usuario no esta logeado. Token de sesion invalido. ingrese de nuevo");

        UserSession sesion = opt.get();

        sessionDao.delete(sesion);

        sesionToken.setMessage("sesion cerrada exitosamente");

        return sesionToken;
    }
    //metodo para verificar si la sesion es en curso
    @Override
    public void checkTokenStatus(String token) {
            Optional<UserSession> opt = sessionDao.findByToken(token);

            if(opt.isPresent()){
                    UserSession session = opt.get();
                    LocalDateTime sessionEndTime = session.getSessionEndTime();
                    boolean flag = false;

                    if(sessionEndTime.isBefore(LocalDateTime.now())){
                        sessionDao.delete(session);
                        flag = true;
                    }

                    deleteExpiredToken();
                    if (flag)
                                throw new LoginException("Sesion expirada.Ingrese de nuevo");

            }
            else {
                    throw new LoginException("El usuario no esta logeado. Token de sesion invalido. Por favor primero ingresa");
            }
    }
    //metodo par eliminar los tokens de los usuarios fuera de sesion
    @Override
    public void deleteExpiredToken() {
            System.out.println("Elimimando tokens internos");

            List<UserSession> users = sessionDao.findAll();

            System.out.println(users);

            if(users.size() > 0){
                    for(UserSession user:users){
                        System.out.println(user.getUserId());
                        LocalDateTime endTime = user.getSessionEndTime();
                        if(endTime.isBefore(LocalDateTime.now())){
                                System.out.println(user.getUserId());
                                sessionDao.delete(user);
                        }
                    }
            }

    }
}
