package io.github.MatheusFSantos.Kernel.KNUsers.model.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Component
@Table(name="tb_backup")
public class UsersBackup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Column(nullable=false)
    private String encryptedData;

    @Column(nullable=false)
    private LocalDateTime createdAt;

    public UsersBackup() { }

    public UsersBackup(String id, String encryptedData) {
        this.id = id;
        this.encryptedData = encryptedData;
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersBackup that = (UsersBackup) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UsersBackup{" +
                "id='" + id + '\'' +
                ", encryptedData='" + encryptedData + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public String getId() {
        return id;
    }

    public void updateId(String id) {
        this.setId(id);
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void updateEncryptedData(String encryptedData) {
        this.setEncryptedData(encryptedData);
    }

    private void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void updateCreatedAt(LocalDateTime createdAt) {
        this.setCreatedAt(createdAt);
    }

    private void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
