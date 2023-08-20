package io.github.MatheusFSantos.Kernel.KNUsers.model.repository;

import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.backup.UsersBackup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersBackupRepository extends JpaRepository<UsersBackup, String> {
}
