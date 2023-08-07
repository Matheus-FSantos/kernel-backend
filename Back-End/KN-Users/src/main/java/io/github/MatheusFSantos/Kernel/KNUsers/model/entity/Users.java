package io.github.MatheusFSantos.Kernel.KNUsers.model.entity;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.MatheusFSantos.Kernel.KNUsers.model.enumeration.Roles;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    @Column(nullable=false, length=25)
    private String password;

    @Column(length=30)
    private String location;

    @Column(length=160)
    private String biography;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Roles roles;

    @Column(nullable=false, updatable=false)
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:s")
    private LocalDateTime createdAt;

    @Column(nullable=false)
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:s")
    private LocalDateTime updatedAt;

    public Users() { }

    public Users(UUID id, String name, String nickname, String email, String password, String location, String biography, Roles roles) {
        this.id = id;
        this.name = name;
        this.nickname = this.updateNicknameInstance(nickname);
        this.email = email;
        this.password = password;
        this.location = location;
        this.biography = biography;
        this.roles = roles;
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
                ", roles=" + roles +
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

    public String updateNicknameInstance(String nickname) {
        StringBuilder readyToSaveNickname = new StringBuilder();

        if(!nickname.substring(0, 1).equals("@"))
            return readyToSaveNickname.append("@").append(nickname).toString();

        return readyToSaveNickname.append(nickname).toString();
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

    public Roles getRoles() {
        return this.roles;
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
