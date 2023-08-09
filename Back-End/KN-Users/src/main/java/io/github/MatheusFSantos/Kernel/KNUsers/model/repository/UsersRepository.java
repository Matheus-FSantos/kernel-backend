package io.github.MatheusFSantos.Kernel.KNUsers.model.repository;

import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    Optional<Users> findByNickname(String nickname);

    Optional<Users> findByEmail(String email);

}
