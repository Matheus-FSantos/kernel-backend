package io.github.MatheusFSantos.Kernel.KNUsers.model.entity.DTO;

import java.io.Serializable;
import java.util.Objects;

public class UsersDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String nickname;

    private String email;

    private String password;

    private String location;

    private String biography;

    public UsersDTO() { }

    public UsersDTO(String name, String nickname, String email, String password, String location, String biography) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.location = location;
        this.biography = biography;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersDTO usersDTO = (UsersDTO) o;
        return Objects.equals(name, usersDTO.name) && Objects.equals(nickname, usersDTO.nickname) && Objects.equals(email, usersDTO.email) && Objects.equals(password, usersDTO.password) && Objects.equals(location, usersDTO.location) && Objects.equals(biography, usersDTO.biography);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nickname, email, password, location, biography);
    }

    @Override
    public String toString() {
        return "UsersDTO{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
    
}
