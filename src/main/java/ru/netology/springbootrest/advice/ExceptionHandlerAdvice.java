package ru.netology.springbootrest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.springbootrest.exceptions.InvalidCredentials;
import ru.netology.springbootrest.exceptions.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    public String HandlerInvalidCredentials (InvalidCredentials e) {
        return "Error " + HttpStatus.BAD_REQUEST +": "+ e.getMessage();
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    public String HandleUnauthorizedUser (UnauthorizedUser e) {
        System.out.println("Error " + HttpStatus.UNAUTHORIZED +": "+ e.getMessage());
        return "Error " + HttpStatus.UNAUTHORIZED +": "+ e.getMessage();
    }
}
