package io.github.MatheusFSantos.Kernel.KNUsers.model.exception.specific.backup;

import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.UsersException;

import java.time.LocalDateTime;
import java.util.List;

public class UsersBackupNotFound extends UsersException {

    public UsersBackupNotFound(List<String> messages, String description, Integer code) {
        super(messages, description, code, LocalDateTime.now());
    }

    public UsersBackupNotFound(String messages, String description, Integer code) {
        super(messages, description, code, LocalDateTime.now());
    }

    public UsersBackupNotFound(List<String> messages, Integer code) {
        super(messages, "No description available.", code, LocalDateTime.now());
    }

    public UsersBackupNotFound(String messages, Integer code) {
        super(messages, "No description available.", code, LocalDateTime.now());
    }

}
