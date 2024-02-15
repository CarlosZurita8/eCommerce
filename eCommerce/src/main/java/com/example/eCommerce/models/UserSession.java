package com.example.eCommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sessionId;

    @Column(unique = true)
    private String token;

    @Column(unique = true)
    private Long userId;

    private String userType;

    private LocalDateTime sessionStartTime;

    private LocalDateTime sessionEndTime;

}
