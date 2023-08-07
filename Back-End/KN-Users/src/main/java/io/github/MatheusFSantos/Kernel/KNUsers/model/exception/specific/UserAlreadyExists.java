package io.github.MatheusFSantos.Kernel.KNUsers.model.exception.specific;

import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.UsersException;

import java.time.LocalDateTime;
import java.util.List;

public class UserAlreadyExists extends UsersException {

    public UserAlreadyExists(List<String> messages, String description, Integer code) {
        super(messages, description, code, LocalDateTime.now());
    }

    public UserAlreadyExists(String messages, String description, Integer code) {
        super(messages, description, code, LocalDateTime.now());
    }

    public UserAlreadyExists(List<String> messages, Integer code) {
        super(messages, "No description available.", code, LocalDateTime.now());
    }

    public UserAlreadyExists(String messages, Integer code) {
        super(messages, "No description available.", code, LocalDateTime.now());
    }

}
