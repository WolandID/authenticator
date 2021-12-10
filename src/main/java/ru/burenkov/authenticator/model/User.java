package ru.burenkov.authenticator.model;

import lombok.Value;

@Value
public class User {
    String clientId;
    String clientSecret;
}
