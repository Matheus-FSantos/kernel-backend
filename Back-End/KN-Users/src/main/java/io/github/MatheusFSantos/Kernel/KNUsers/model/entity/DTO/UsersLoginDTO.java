package io.github.MatheusFSantos.Kernel.KNUsers.model.entity.DTO;

import io.github.MatheusFSantos.Kernel.KNUsers.model.annotation.DTO;

import java.io.Serializable;
import java.util.Objects;

@DTO
public class UsersLoginDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;
    private String password;

    public UsersLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersLoginDTO that = (UsersLoginDTO) o;
        return Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
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

}
