package ru.burenkov.authenticator.service;

public interface TokenService {
    String generateToken(String clientId);
}
