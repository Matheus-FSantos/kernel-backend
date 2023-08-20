package io.github.MatheusFSantos.Kernel.KNUsers.model.service;

import io.github.MatheusFSantos.Kernel.KNUsers.model.annotation.Authorize;
import io.github.MatheusFSantos.Kernel.KNUsers.model.annotation.BusinessCritical;
import io.github.MatheusFSantos.Kernel.KNUsers.model.annotation.ReadOnly;
import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.DTO.UsersBackupDTO;
import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.backup.UsersBackup;
import io.github.MatheusFSantos.Kernel.KNUsers.model.enumeration.Roles;
import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.UsersException;
import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.specific.UsersNotFound;
import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.specific.backup.UsersBackupNotFound;
import io.github.MatheusFSantos.Kernel.KNUsers.model.repository.UsersBackupRepository;
import io.github.MatheusFSantos.Kernel.KNUsers.model.util.cryptography.algorithms.Base64;
import io.github.MatheusFSantos.Kernel.KNUsers.model.util.json.GSONConverter;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@BusinessCritical
public class UsersBackupService {

    @Autowired
    private UsersBackupRepository usersBackupRepository;

    @ReadOnly
    @Authorize(role="ADMIN", required=true)
    public List<UsersBackup> findAllEncoded() throws UsersException {
        List<UsersBackup> usersBackupList = this.usersBackupRepository.findAll();

        if(!usersBackupList.isEmpty())
            return usersBackupList;

        throw new UsersBackupNotFound("Users backup not found in database!", "The method was invoked to list all users backup (find all method), however the database is empty", HttpStatus.SC_NOT_FOUND);
    }

    @ReadOnly
    @Authorize(role="ADMIN", required=true)
    public UsersBackup findByIdEncoded(String id) throws UsersException {
        return this.usersBackupRepository.findById(id).orElseThrow(() -> new UsersBackupNotFound("User backup not found in database!", "The method was invoked to a user backup (method find by id), but the user is not present in the database of this service", HttpStatus.SC_NOT_FOUND));
    }

    @Authorize(role="ADMIN", required=true)
    public void save(UsersBackupDTO userBackupDTO) {
        GSONConverter gsonConverter = new GSONConverter();
        String userBackupJSON = gsonConverter.serializable(userBackupDTO);
        String userBackupEncryptedData = Base64.encoder(userBackupJSON);

        UsersBackup userBackup = new UsersBackup(UUID.randomUUID().toString(), userBackupEncryptedData, userBackupDTO.getCreatedAt());
        this.usersBackupRepository.save(userBackup);
    }

}
