package io.github.MatheusFSantos.Kernel.KNUsers.model.exception.specific;

import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.UsersException;

import java.time.LocalDateTime;
import java.util.List;

public class UserLoginNotValid extends UsersException {

    public UserLoginNotValid(List<String> messages, String description, Integer code) {
        super(messages, description, code, LocalDateTime.now());
    }

    public UserLoginNotValid(String messages, String description, Integer code) {
        super(messages, description, code, LocalDateTime.now());
    }

    public UserLoginNotValid(List<String> messages, Integer code) {
        super(messages, "No description available.", code, LocalDateTime.now());
    }

    public UserLoginNotValid(String messages, Integer code) {
        super(messages, "No description available.", code, LocalDateTime.now());
    }

}
