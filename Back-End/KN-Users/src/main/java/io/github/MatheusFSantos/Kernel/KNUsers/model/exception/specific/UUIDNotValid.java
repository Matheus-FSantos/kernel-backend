package io.github.MatheusFSantos.Kernel.KNUsers.model.exception.specific;

import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.UsersException;

import java.time.LocalDateTime;
import java.util.List;

public class UUIDNotValid extends UsersException {

    public UUIDNotValid(List<String> messages, String description, Integer code) {
        super(messages, description, code, LocalDateTime.now());
    }

    public UUIDNotValid(String messages, String description, Integer code) {
        super(messages, description, code, LocalDateTime.now());
    }

    public UUIDNotValid(List<String> messages, Integer code) {
        super(messages, "No description available.", code, LocalDateTime.now());
    }

    public UUIDNotValid(String messages, Integer code) {
        super(messages, "No description available.", code, LocalDateTime.now());
    }

}
