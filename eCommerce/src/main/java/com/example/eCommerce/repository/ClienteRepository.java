package com.example.repository;

import com.example.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNumTelefono(String numTelefono);
    /*Optional<Cliente> findByEmailId(String emailId);
    Optional<Cliente> findByNumTelOEmailId(String numTelefono,String emailId);*/

}
