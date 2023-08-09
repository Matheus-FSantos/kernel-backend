package io.github.MatheusFSantos.Kernel.KNUsers.model.service;

import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.DTO.UsersDTO;
import io.github.MatheusFSantos.Kernel.KNUsers.model.entity.Users;
import io.github.MatheusFSantos.Kernel.KNUsers.model.enumeration.Roles;
import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.UsersException;
import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.specific.UserAlreadyExists;
import io.github.MatheusFSantos.Kernel.KNUsers.model.exception.specific.UsersNotFound;
import io.github.MatheusFSantos.Kernel.KNUsers.model.repository.UsersRepository;
import io.github.MatheusFSantos.Kernel.KNUsers.model.validation.UsersValidations;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAll() throws UsersException {
        List<Users> usersList = this.usersRepository.findAll();

        if(!usersList.isEmpty())
            return usersList;

        throw new UsersNotFound("Users not found in database!", "The method was invoked to list all users (find all method), however the database is empty", HttpStatus.SC_NOT_FOUND);
    }

    public Users findById(String id) throws UsersException {
        return this.usersRepository.findById(id).orElseThrow(() -> new UsersNotFound("User not found in database!", "The method was invoked to list a user (method find by id), but the user is not present in the database of this service", HttpStatus.SC_NOT_FOUND));
    }

    public void save(UsersDTO usersDTO) throws UsersException {
        UsersValidations.validation(usersDTO);

        if(this.usersRepository.findByNickname(usersDTO.getNickname()).isPresent() || this.usersRepository.findByEmail(usersDTO.getEmail()).isPresent())
            throw new UserAlreadyExists("User already exists!", "The method was invoked to save one user (save method), however this user already exists.", HttpStatus.SC_CONFLICT);

        Users user = new Users(UUID.randomUUID().toString(), usersDTO.getName(), usersDTO.getNickname(), usersDTO.getPassword(), usersDTO.getLocation(), usersDTO.getLocation(), usersDTO.getBiography(), Roles.BASIC);
        this.usersRepository.save(user);
    }

    public void update() {

    }

    public void delete(String id) throws UsersException {
        if(this.findById(id) != null)
            this.usersRepository.deleteById(id);
    }

}
