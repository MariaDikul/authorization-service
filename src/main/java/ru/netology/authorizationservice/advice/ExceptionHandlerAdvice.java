package ru.netology.authorizationservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.authorizationservice.exceptions.InvalidCredentials;
import ru.netology.authorizationservice.exceptions.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler(InvalidCredentials e) {
        return new ResponseEntity<>("User name or password is empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uuHandler(UnauthorizedUser e) {
        return new ResponseEntity<>("Unknown user", HttpStatus.UNAUTHORIZED);
    }

}
