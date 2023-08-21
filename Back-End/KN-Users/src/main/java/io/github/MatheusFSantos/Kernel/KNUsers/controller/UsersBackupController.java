package io.github.MatheusFSantos.Kernel.KNUsers.controller;

import io.github.MatheusFSantos.Kernel.KNUsers.model.annotation.controller.UserBackupController;
import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.DTO.UsersBackupDecryptedDTO;
import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.backup.UsersBackup;
import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.UsersException;
import io.github.MatheusFSantos.Kernel.KNUsers.model.service.UsersBackupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@UserBackupController
public class UsersBackupController {

    @Autowired
    private UsersBackupService usersBackupService;

    @GetMapping("/encrypted")
    public ResponseEntity<List<UsersBackup>> findAllEncoded() throws UsersException {
        return ResponseEntity.ok().body(this.usersBackupService.findAllEncoded());
    }

    @GetMapping("/encrypted/{id}")
    public ResponseEntity<UsersBackup> findByIdEncoded(@PathVariable String id) throws UsersException {
        return ResponseEntity.ok().body(this.usersBackupService.findByIdEncoded(id));
    }
    @GetMapping("/decrypted")
    public ResponseEntity<List<UsersBackupDecryptedDTO>> findAllDecoded() throws UsersException {
        return ResponseEntity.ok().body(this.usersBackupService.findAllDecoded());
    }

    @GetMapping("/decrypted/{id}")
    public ResponseEntity<UsersBackupDecryptedDTO> findByIdDecoded(@PathVariable String  id) throws UsersException {
        return ResponseEntity.ok().body(this.usersBackupService.findByIdDecoded(id));
    }



}
