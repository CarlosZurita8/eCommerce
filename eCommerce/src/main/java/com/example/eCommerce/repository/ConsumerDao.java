package com.example.eCommerce.repository;

import com.example.eCommerce.models.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsumerDao extends JpaRepository<Consumer, Long> {

    Optional<Consumer> findByMobileNo(String mobileNo);


    }




