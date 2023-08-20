package io.github.MatheusFSantos.Kernel.KNUsers.model.validation;

import static org.junit.jupiter.api.Assertions.*;

import io.github.MatheusFSantos.Kernel.KNUsers.model.util.validation.UsersValidations;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersValidationsTests {

    private UsersValidations usersValidations;

    @Test
    void regexNameTests() {
        String regex = "^[A-Za-z]+\\s[A-Za-z]+$";
        String name = "Matheus Ferreira Santos";
        String name2 = "Matheus Ferreira";

        Boolean response = name.matches(regex);
        Boolean response2 = name2.matches(regex);
        assertNotEquals(true, response);
        assertEquals(true, response2);
    }

    @Test
    void regexNicknameTests() {
        String regex = "^[a-zA-Z0-9._]+$";
        String nickname = "matheus.ffff";
        String nickname2 = "@testando111";

        Boolean response = nickname.matches(regex);
        Boolean response2 = nickname.matches(nickname2);
        assertEquals(true, response);
        assertNotEquals(true, response2);
    }

    @Test
    void regexEmailTests() {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String email = "matheus.contato@gmail.com";
        String email2 = "invalid.email";

        Boolean response = email.matches(regex);
        Boolean response2 = email2.matches(regex);
        assertEquals(true, response);
        assertNotEquals(true, response2);
    }

    @Test
    void regexPasswordTests() {
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
        String password = "123456789";
        String password2 = "validPassword123@";

        Boolean response = password.matches(regex);
        Boolean response2 = password2.matches(regex);
        assertEquals(false, response);
        assertEquals(true, response2);
    }

}
