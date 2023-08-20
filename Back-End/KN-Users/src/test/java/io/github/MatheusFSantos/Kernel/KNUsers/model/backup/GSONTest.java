package io.github.MatheusFSantos.Kernel.KNUsers.model.backup;

import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.DTO.UsersBackupDTO;
import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.Users;
import io.github.MatheusFSantos.Kernel.KNUsers.model.enumeration.Roles;
import io.github.MatheusFSantos.Kernel.KNUsers.model.util.json.GSONConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class GSONTest {

    @Test
    void objectSerializableWithGSON() {
        GSONConverter gsonConverter = new GSONConverter();

        Users user = new Users(UUID.randomUUID().toString(), "Matheus Ferreira", "@Math", "matheus.fs.contato@gmail.com", "D94ed@@", "São Paulo/SP", "Java Developer", Roles.ADMIN);
        UsersBackupDTO userBackupDTO = new UsersBackupDTO(user);

        String json = gsonConverter.serializable(userBackupDTO);
        System.out.println(json);
    }

    @Test
    void objectDeserializableWithGSON() {
        GSONConverter gsonConverter = new GSONConverter();

        Users user = new Users(UUID.randomUUID().toString(), "Matheus Ferreira", "@Math", "matheus.fs.contato@gmail.com", "D94ed@@", "São Paulo/SP", "Java Developer", Roles.ADMIN);
        UsersBackupDTO userBackupDTOOriginal = new UsersBackupDTO(user);
        String json = gsonConverter.serializable(userBackupDTOOriginal);

        UsersBackupDTO userBackupDTODeserializable = gsonConverter.deserializable(json);

        Assertions.assertEquals(userBackupDTOOriginal, userBackupDTODeserializable);
        System.out.println("Expected -> " + userBackupDTOOriginal + "\nActual -> " + userBackupDTODeserializable);
    }

}
