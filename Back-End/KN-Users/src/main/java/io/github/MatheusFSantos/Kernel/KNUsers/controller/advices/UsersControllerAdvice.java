package io.github.MatheusFSantos.Kernel.KNUsers.controller.advices;

import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.DTO.UsersExceptionDTO;
import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.UsersException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UsersControllerAdvice {

    @ExceptionHandler(UsersException.class)
    public ResponseEntity<UsersExceptionDTO> handleNotFoundExceptions(UsersException usersException) {
        return ResponseEntity.status(usersException.getStatus()).body(new UsersExceptionDTO(usersException.getMessages(), usersException.getDescription(), usersException.getStatus(), usersException.getDate()));
    }

}
