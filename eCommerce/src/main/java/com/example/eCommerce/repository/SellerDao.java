package com.example.eCommerce.repository;

import com.example.eCommerce.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface SellerDao extends JpaRepository<Seller,Long> {

    Optional<Seller> findByMobileNo(String mobileNo);
}
