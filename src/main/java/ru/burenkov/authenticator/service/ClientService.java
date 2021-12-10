package ru.burenkov.authenticator.service;

import ru.burenkov.authenticator.exception.RegistrationException;

public interface ClientService {
    void register(String clientId,String clientSecret) throws RegistrationException;
    void checkCredentials(String clientId,String clientSecret);
}
