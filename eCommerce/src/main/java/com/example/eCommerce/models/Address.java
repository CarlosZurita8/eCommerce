package com.example.eCommerce.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long addressId;

        private String streetNo;

        private String buildingName;

        private String locality;

        private String city;

        private String state;


}
