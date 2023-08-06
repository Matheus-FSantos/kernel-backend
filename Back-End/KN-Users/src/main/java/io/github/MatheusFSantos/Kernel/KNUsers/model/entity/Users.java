package io.github.MatheusFSantos.Kernel.KNUsers.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Component
@Table(name="tb_users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(updatable=false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(nullable=false, length=60)
    private String name;

    @Column(nullable=false, unique=true, length=30)
    private String nickname;

    @Column(nullable=false, unique=true, length=60)
    private String email;

    @Column(nullable=false, length=35)
    private String password;

    //roles

    @Column(length=30)
    private String location;

    @Column(length=160)
    private String biography;

    @Column(nullable=false, updatable=false)
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:s")
    private LocalDateTime createdAt;

    @Column(nullable=false)
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:s")
    private LocalDateTime updatedAt;

    public Users() { }

    public Users(UUID id, String name, String nickname, String email, String password, String location, String biography) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.location = location;
        this.biography = biography;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", biography='" + biography + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public UUID getId() {
        return id;
    }

    public void updateId(UUID id) {
        this.setId(id);
    }

    private void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void updateName(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void updateNickname(String nickname) {
        this.setNickname(nickname);
    }

    private void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void updateEmail(String email) {
        this.setEmail(email);
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void updatePassword(String password) {
        this.setPassword(password);
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.setLocation(location);
    }

    private void setLocation(String location) {
        this.location = location;
    }

    public String getBiography() {
        return biography;
    }

    public void updateBiography(String biography) {
        this.setBiography(biography);
    }

    private void setBiography(String biography) {
        this.biography = biography;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void updateCreatedAtNOW() {
        this.setCreatedAt(LocalDateTime.now());
    }

    public void updateCreatedAt(LocalDateTime createdAt) {
        this.setCreatedAt(createdAt);
    }

    private void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void updateUpdatedAtNOW() {
        this.setUpdatedAt(LocalDateTime.now());
    }

    public void updateUpdatedAt(LocalDateTime updatedAt) {
        this.setUpdatedAt(updatedAt);
    }

    private void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
