package ru.burenkov.authenticator;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.burenkov.authenticator.exception.LoginException;
import ru.burenkov.authenticator.exception.RegistrationException;
import ru.burenkov.authenticator.model.ErrorResponse;
import ru.burenkov.authenticator.model.TokenResponse;
import ru.burenkov.authenticator.model.User;
import ru.burenkov.authenticator.service.ClientService;
import ru.burenkov.authenticator.service.TokenService;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody User user){
      clientService.register(user.getClientId(), user.getClientSecret());
      return ResponseEntity.ok("Register");
    }

    @PostMapping("/token")
    public TokenResponse getToken(@RequestBody User user){
        clientService.checkCredentials(user.getClientId(), user.getClientSecret());
        return new TokenResponse(tokenService.generateToken(user.getClientId()));
    }

    @ExceptionHandler({RegistrationException.class, LoginException.class})
    public ResponseEntity<ErrorResponse> handleUserRegistrationException(RuntimeException ex) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(ex.getMessage()));
    }
}
