package io.github.MatheusFSantos.Kernel.KNUsers.model.crypto.algorithms;

import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.DTO.UsersBackupDTO;
import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.Users;
import io.github.MatheusFSantos.Kernel.KNUsers.model.enumeration.Roles;
import io.github.MatheusFSantos.Kernel.KNUsers.model.util.cryptography.algorithms.Base64;
import io.github.MatheusFSantos.Kernel.KNUsers.model.util.json.GSONConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class Base64Tests {

    @Test
    void encrypt() {
        GSONConverter gsonConverter = new GSONConverter();

        Users user = new Users(UUID.randomUUID().toString(), "Matheus Ferreira", "@Math", "matheus.fs.contato@gmail.com", "D94ed@@", "São Paulo/SP", "Java Developer", Roles.ADMIN);
        UsersBackupDTO userBackupDTO = new UsersBackupDTO(user);

        String json = gsonConverter.serializable(userBackupDTO);
        String cryptoJson = Base64.encoder(json);

        System.out.println(cryptoJson);
        Assertions.assertNotEquals(0, cryptoJson.length());
    }

    @Test
    void decrypt() {
        GSONConverter gsonConverter = new GSONConverter();

        Users user = new Users(UUID.randomUUID().toString(), "Matheus Ferreira", "@Math", "matheus.fs.contato@gmail.com", "D94ed@@", "São Paulo/SP", "Java Developer", Roles.ADMIN);
        UsersBackupDTO userBackupDTO = new UsersBackupDTO(user);

        String jsonBefore = gsonConverter.serializable(userBackupDTO);
        String cryptoJson = Base64.encoder(jsonBefore);

        String jsonAfter = Base64.decode(cryptoJson);

        System.out.println("Expected -> " + jsonBefore + "\nActual -> " + jsonAfter);
        Assertions.assertEquals(jsonBefore, jsonAfter);
    }

}
