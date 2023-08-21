package io.github.MatheusFSantos.Kernel.KNUsers.model.entity.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class UsersBackupDecryptedDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private UsersBackupDTO userBackupInformation;

    private LocalDateTime createdAt;

    public UsersBackupDecryptedDTO() { }

    public UsersBackupDecryptedDTO(String id, UsersBackupDTO userBackupInformation, LocalDateTime createdAt) {
        this.id = id;
        this.userBackupInformation = userBackupInformation;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersBackupDecryptedDTO that = (UsersBackupDecryptedDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UsersBackupDecryptedDTO{" +
                "id='" + id + '\'' +
                ", userBackupInformation=" + userBackupInformation +
                ", createdAt=" + createdAt +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UsersBackupDTO getUserBackupInformation() {
        return userBackupInformation;
    }

    public void setUserBackupInformation(UsersBackupDTO userBackupInformation) {
        this.userBackupInformation = userBackupInformation;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
