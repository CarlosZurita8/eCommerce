package com.example.eCommerce.service;

import com.example.eCommerce.dto.ConsumerDto;
import com.example.eCommerce.dto.SessionDto;
import com.example.eCommerce.models.UserSession;

public interface LonginLogoutService {

    public UserSession loginConsumer(ConsumerDto loginConsumer);

    public SessionDto logoutConsumer(SessionDto session);

    public void checkTokenStatus(String token);

    public void deleteExpiredToken();
}
