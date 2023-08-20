package io.github.MatheusFSantos.Kernel.KNUsers.model.exception.specific;

import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.UsersException;

import java.time.LocalDateTime;
import java.util.List;

public class UserUUIDNotValid extends UsersException {

    public UserUUIDNotValid(List<String> messages, String description, Integer code) {
        super(messages, description, code, LocalDateTime.now());
    }

    public UserUUIDNotValid(String messages, String description, Integer code) {
        super(messages, description, code, LocalDateTime.now());
    }

    public UserUUIDNotValid(List<String> messages, Integer code) {
        super(messages, "No description available.", code, LocalDateTime.now());
    }

    public UserUUIDNotValid(String messages, Integer code) {
        super(messages, "No description available.", code, LocalDateTime.now());
    }

}
